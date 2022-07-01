package com.rentcar.CarImformation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Carcontroller {

    @Autowired
    @Qualifier("com.rentcar.CarImformation.CartServiceImpl")
    private CarService service;

    @GetMapping("/create")
    public String create(){
    return "/create";
    }




    @GetMapping("/{id}")
    public String hello(@PathVariable("id") int id){
        return id + "입니다.";
    }
}
