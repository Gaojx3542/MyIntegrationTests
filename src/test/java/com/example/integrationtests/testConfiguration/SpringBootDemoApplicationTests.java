package com.example.integrationtests.testConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @author Gaojx
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringBootDemoApplicationTests {

    @LocalServerPort
    int randomServerPort;

    @Autowired
    DataSource datasource;

    //tests



    @TestConfiguration
    static class MyTestConfiguration {

        //tests specific beans
        @Bean
        DataSource createDataSource(){
            //
            return null;
        }
    }
}
