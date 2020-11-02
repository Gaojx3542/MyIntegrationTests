package com.example.integrationtests.serviceTest;

import com.example.integrationtests.dao.EmployeeRepository;
import com.example.integrationtests.model.Employee;
import com.example.integrationtests.entity.Employees;
import com.example.integrationtests.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author Gaojx
 */
public class EmployeeServiceTest {

    @InjectMocks
    EmployeeService employeeService;

    @Mock
    EmployeeRepository employeeRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllEmployeesTest(){
        List<Employee> list = new ArrayList<Employee>();
        Employee empOne = new Employee(1, "John", "John", "howtodoinjava@gmail.com");
        Employee empTwo = new Employee(2, "Alex", "kolenchiski", "alexk@yahoo.com");
        Employee empThree = new Employee(3, "Steve", "Waugh", "swaugh@gmail.com");

        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);

        Employees employees = new Employees();
        employees.setEmployeeList(list);

        when(employeeRepository.getAllEmployees()).thenReturn(employees);

        //test
        Employees empList = employeeService.getEmployeeList();

        assertEquals(3, empList.getEmployeeList().size());
        verify(employeeRepository, times(1)).getAllEmployees();

    }

    @Test
    public void getEmployeeByIdTest(){
        when(employeeRepository.findById((long) 1).get()).thenReturn(new Employee(1,"Lokesh","Gupta","user@email.com"));

        Employee emp = employeeService.getEmployeeById(1);

        assertEquals("Lokesh", emp.getFirstName());
        assertEquals("Gupta", emp.getLastName());
        assertEquals("user@email.com", emp.getEmail());
    }

    @Test
    public void createEmployeeTest(){
        Employee emp = new Employee(1,"Lokesh","Gupta","user@email.com");

        employeeService.addEmployee(emp);

        verify(employeeRepository, times(1)).addEmployee(emp);
    }
}
