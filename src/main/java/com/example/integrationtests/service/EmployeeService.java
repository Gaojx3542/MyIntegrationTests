package com.example.integrationtests.service;

import com.example.integrationtests.model.Employee;
import com.example.integrationtests.entity.Employees;

/**
 * @author Gaojx
 */
public interface EmployeeService {

    Employees getEmployeeList();

    Employee getEmployeeById(Integer id);

    int addEmployee(Employee employee);
}
