package com.rentcar.config;


import com.rentcar.utility.UploadList;

 
<<<<<<< HEAD
import com.rentcar.utility.UploadCon;
=======


>>>>>>> ef8db476309123585ff1cbfc0044a0080c84c9c4
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

<<<<<<< HEAD

//import com.study.contents.*;

 
=======
>>>>>>> ef8db476309123585ff1cbfc0044a0080c84c9c4
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
<<<<<<< HEAD
        // Windows: path = "f:/AIstudy/deploy/shopping/contents/storage";
        // ▶ file:///f:/AIstudy/deploy/shopping/contents/storage
        // Ubuntu: path = "/home/ubuntu/deploy/shopping/contents/storage";
        // ▶ file:////home/ubuntu/deploy/shopping/contents/storage
        // JSP 인식되는 경로: http://localhost:8000/contents/storage";
        registry.addResourceHandler("/carinfo/storage/**")
        .addResourceLocations("file:///" + UploadCon.getUploadDir());
//        registry.addResourceHandler("/member/storage/**")
//                 .addResourceLocations("file:///" + UploadMem.getUploadDir());
=======


        registry.addResourceHandler("/ckstorage/files/**")
                .addResourceLocations("file:///"+ UploadList.getUploadDir()+"/files/");

 
       registry.addResourceHandler("/ckstorage/files/**")
               .addResourceLocations("file:///"+ UploadList.getUploadDir()+"/files/");

>>>>>>> ef8db476309123585ff1cbfc0044a0080c84c9c4
    }

}