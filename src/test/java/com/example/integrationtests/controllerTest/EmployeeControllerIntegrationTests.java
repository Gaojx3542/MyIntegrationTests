package com.example.integrationtests.controllerTest;

import com.example.integrationtests.MyIntegrationTestsApplication;
import com.example.integrationtests.model.Employee;
import com.example.integrationtests.entity.Employees;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Gaojx
 */
@SpringBootTest(classes = MyIntegrationTestsApplication.class,
        webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntegrationTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

//    @Sql({ "schema.sql", "data.sql" })
    @Test
    public void testAllEmployees()
    {
        System.out.println(port);
        assertTrue(
                this.restTemplate
                        .getForObject("http://localhost:" + port + "/employees/", Employees.class)
                        .getEmployeeList().size() == 3);
    }

    @Test
    public void testAddEmployee() {
        Employee employee = new Employee("Lokesh", "Gupta", "howtodoinjava@gmail.com");
        ResponseEntity<String> responseEntity = this.restTemplate
                .postForEntity("http://localhost:" + port + "/employees/", employee, String.class);
        assertEquals(201, responseEntity.getStatusCodeValue());
    }
}
