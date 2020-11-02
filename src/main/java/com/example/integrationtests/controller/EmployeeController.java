package com.example.integrationtests.controller;

import com.example.integrationtests.dao.EmployeeRepository;
import com.example.integrationtests.model.Employee;
import com.example.integrationtests.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;

/**
 * @author Gaojx
 */
@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(path="/", produces = "application/json")
    public Employees getEmployees()
    {
        Employees response = new Employees();
        ArrayList<Employee> list = new ArrayList<>();
        employeeRepository.findAll().forEach(e -> list.add(e));
        response.setEmployeeList(list);
        return response;
    }

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(
//            @RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
//            @RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
               @RequestBody Employee employee) {

        //add resource
        employeeRepository.addEmployee(employee);

        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();

        //Send location in response
        return ResponseEntity.created(location).build();
    }
}
