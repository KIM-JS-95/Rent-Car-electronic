package com.rentcar.config;

import com.rentcar.application;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

<<<<<<< HEAD
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(com.rentcar.application.class);
	}
=======

>>>>>>> ef8db476309123585ff1cbfc0044a0080c84c9c4

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(application.class);
    }



}