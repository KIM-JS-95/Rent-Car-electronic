package com.rentcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
<<<<<<< HEAD
//@ComponentScan("com.rentcar.member.MemberMapper")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
=======
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
>>>>>>> bad000463133901f31a3de4210065a3e003691c8
public class application {
    public static void main(String[] args) {
        SpringApplication.run(application.class, args);
    }
}
