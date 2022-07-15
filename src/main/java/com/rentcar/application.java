package com.rentcar;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

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
