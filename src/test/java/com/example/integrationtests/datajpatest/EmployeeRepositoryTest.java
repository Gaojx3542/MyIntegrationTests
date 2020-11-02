package com.example.integrationtests.datajpatest;

import com.example.integrationtests.dao.EmployeeRepository;
import com.example.integrationtests.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Gaojx
 */
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository repository;

    @Test
    public void testRepository()
    {
        Employee emp = new Employee();
        emp.setFirstName("Lokesh");
        emp.setLastName("Gupta");
        emp.setEmail("howtodoinjava@gmail.com");

        repository.save(emp);

        assertThat(emp.getId()).isNotNull();
    }
}
