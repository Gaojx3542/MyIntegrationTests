package com.example.integrationtests.SpringbootTests;

import com.example.integrationtests.dao.EmployeeRepository;
import com.example.integrationtests.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Using @SpringBootTest for unit testing
 * @author Gaojx
 */
@SpringBootTest(classes = {EmployeeRepository.class, EmployeeService.class})
public class UnitTest {

    @Autowired
    private EmployeeService employeeService;


}
