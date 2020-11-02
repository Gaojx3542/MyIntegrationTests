package com.example.integrationtests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockito-junit-example/
 * @author Gaojx
 */
@SpringBootApplication
@EnableTransactionManagement
public class MyIntegrationTestsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyIntegrationTestsApplication.class, args);
    }

}
