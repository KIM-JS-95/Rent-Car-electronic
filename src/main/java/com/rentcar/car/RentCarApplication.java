package com.rentcar.car;


@SpringBootApplication
@ComponentScan(basePackages= {"com.rentcar.car"})
public class RentCarApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentCarApplication.class, args);
    }
}
