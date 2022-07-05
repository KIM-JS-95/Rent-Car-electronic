package com.rentcar.kakao.controller;


import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mapcontroller {

    @GetMapping("/")
    public String home(){
        return "/home";
    }


    @GetMapping("/map/map")
    public String map(){
        return "/map";
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
