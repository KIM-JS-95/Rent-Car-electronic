package com.rentcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
<<<<<<< HEAD
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
=======
>>>>>>> 46356a484a6a804c164d0363a2722019d4bd8afd

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
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
