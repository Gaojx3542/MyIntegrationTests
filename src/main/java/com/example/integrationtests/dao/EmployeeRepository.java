package com.example.integrationtests.dao;

import com.example.integrationtests.model.Employee;
import com.example.integrationtests.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Gaojx
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Transactional
    @Modifying
    @Query(value = "insert into Employee (id, first_name, second_name, email) values " +
            "(:#{#employee.id}, :#{#employee.firstName}, :#{#employee.secondName}, :#{#employee.email})", nativeQuery = true)
    int addEmployee(Employee employee);


    @Query("select e from Employee e ")
    Employees getAllEmployees();

}
