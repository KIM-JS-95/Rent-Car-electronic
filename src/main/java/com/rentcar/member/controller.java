package com.rentcar.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
