package com.rentcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
<<<<<<< HEAD
=======

>>>>>>> ef8db476309123585ff1cbfc0044a0080c84c9c4

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class application {
    public static void main(String[] args) {

        SpringApplication.run(application.class, args);
    }
}
