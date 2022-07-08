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
>>>>>>> c683c843e4ce19783d84ab38dc314002ec6a14f6

}
