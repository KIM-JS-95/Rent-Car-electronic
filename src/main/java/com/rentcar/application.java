package com.rentcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
<<<<<<< HEAD
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
=======
@ComponentScan("com.in28minutes.springboot")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
>>>>>>> c683c843e4ce19783d84ab38dc314002ec6a14f6
public class application {
    public static void main(String[] args) {

        SpringApplication.run(application.class, args);
    }
}
