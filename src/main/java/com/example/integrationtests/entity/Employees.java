package com.example.integrationtests.entity;

import com.example.integrationtests.model.Employee;

import java.util.List;

/**
 * @author Gaojx
 */

public class Employees {

    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
