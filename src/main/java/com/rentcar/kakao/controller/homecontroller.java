package com.rentcar.kakao.controller;


import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homecontroller {


    @GetMapping("/")
    public String home(){
        System.out.println("check");
        return "/home";
    }
}
