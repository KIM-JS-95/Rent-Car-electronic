package com.rentcar.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
=======
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
>>>>>>> 2cd4316c2f65aefb2564356757dd7f5c4e52be9c

@RestController
public class Controller {

    @Autowired
    @Qualifier("com.rentcar.member.MemberServiceImpl")
    private MemberService service;




    @GetMapping("/get/{car_license}")
    public String user(@RequestParam String car_license ){
       List<MemberDTO> list = service.carData(car_license);
        System.out.println(list);

        return "list";
    }
}