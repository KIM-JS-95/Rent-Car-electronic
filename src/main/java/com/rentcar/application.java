package com.rentcar;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
=======

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

>>>>>>> 9de60db3876c7e61389e427f34cb52a9a34d569d
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class application {

    public static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:application.properties,"
            + "classpath:kakao.properties";

    public static void main(String[] args) {
        new SpringApplicationBuilder(application.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);
    }
}