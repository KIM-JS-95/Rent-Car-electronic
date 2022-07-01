package com.rentcar.CartImformation;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Carcontroller {

    @GetMapping("/{id}")
    public String hello(@PathVariable("id") int id){
        return id + "입니다.";
    }
}
