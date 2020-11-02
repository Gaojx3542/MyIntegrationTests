package com.example.integrationtests.service.impl;

import com.example.integrationtests.dao.EmployeeRepository;
import com.example.integrationtests.model.Employee;
import com.example.integrationtests.entity.Employees;
import com.example.integrationtests.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Gaojx
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employees getEmployeeList() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(Long.valueOf(id)).get();
    }

    @Override
    public int addEmployee(Employee employee) {
        return employeeRepository.addEmployee(employee);
    }
}
