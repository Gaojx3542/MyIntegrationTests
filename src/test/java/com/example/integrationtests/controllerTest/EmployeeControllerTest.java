package com.example.integrationtests.controllerTest;

import com.example.integrationtests.controller.EmployeeController;
import com.example.integrationtests.dao.EmployeeRepository;
import com.example.integrationtests.model.Employee;
import com.example.integrationtests.entity.Employees;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @author Gaojx
 */
@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {
    @InjectMocks
    EmployeeController employeeController;

    @Mock
    EmployeeRepository employeeRepository;

    @Test
    public void testAddEmployee()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(employeeRepository.addEmployee(any(Employee.class))).thenReturn(1);

        Employee employee = new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com");
        ResponseEntity<Object> responseEntity = employeeController.addEmployee(employee);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
    }

    @Test
    public void testFindAll()
    {
        // given
        Employee employee1 = new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com");
        Employee employee2 = new Employee(2, "Alex", "Gussin", "example@gmail.com");
        Employees employees = new Employees();
        employees.setEmployeeList(Arrays.asList(employee1, employee2));

        when(employeeRepository.getAllEmployees()).thenReturn(employees);

        // when
        Employees result = employeeController.getEmployees();

        // then
        assertThat(result.getEmployeeList().size()).isEqualTo(2);

        assertThat(result.getEmployeeList().get(0).getFirstName())
                .isEqualTo(employee1.getFirstName());

        assertThat(result.getEmployeeList().get(1).getFirstName())
                .isEqualTo(employee2.getFirstName());
    }
}
