package com.rentcar.member;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping("/{id}")
    public String hello(@PathVariable("id") int id){
        return id + "입니다.";
    }
}
