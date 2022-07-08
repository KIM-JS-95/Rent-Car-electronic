package com.rentcar.config;

import com.rentcar.application;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {


<<<<<<< HEAD
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(application.class);
    }
=======
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(application.class);
	}
>>>>>>> bad000463133901f31a3de4210065a3e003691c8

}