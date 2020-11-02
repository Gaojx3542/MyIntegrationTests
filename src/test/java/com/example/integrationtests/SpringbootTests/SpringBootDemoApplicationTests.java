package com.example.integrationtests.SpringbootTests;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

/**
 * Using @SpringBootTest for integration testing
 * @author Gaojx
 */

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootDemoApplicationTests
{
    @LocalServerPort
    int randomServerPort;

    //---- tests -----
    @Test
    public void test1(){
        System.out.println(randomServerPort);
    }
}
