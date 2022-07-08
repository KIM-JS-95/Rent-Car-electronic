package com.rentcar.config;
<<<<<<< HEAD


import com.rentcar.utility.UploadList;
=======
 
import com.rentcar.list.UploadList;
>>>>>>> bad000463133901f31a3de4210065a3e003691c8
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
<<<<<<< HEAD

        registry.addResourceHandler("/ckstorage/files/**")
                .addResourceLocations("file:///"+ UploadList.getUploadDir()+"/files/");
=======
 
       registry.addResourceHandler("/ckstorage/files/**")
               .addResourceLocations("file:///"+ UploadList.getUploadDir()+"/files/");
>>>>>>> bad000463133901f31a3de4210065a3e003691c8
    }

}