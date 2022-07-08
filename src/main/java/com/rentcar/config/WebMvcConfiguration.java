package com.rentcar.config;
 
import com.rentcar.list.UploadList;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
 
       registry.addResourceHandler("/ckstorage/files/**")
               .addResourceLocations("file:///"+ UploadList.getUploadDir()+"/files/");
    }
 
}