package com.example.integrationtests.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author Gaojx
 */
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "persistenceGenerator", strategy = "increment")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;


    public Employee(){}

    public Employee(String firstName, String secondName, String email) {
        this.firstName = firstName;
        this.lastName = secondName;
        this.email = email;
    }

    public Employee(Integer id, String firstName, String secondName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = secondName;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
