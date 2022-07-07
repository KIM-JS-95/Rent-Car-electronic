package com.rentcar.support.controller;

import com.rentcar.support.model.Request;
import com.rentcar.support.service.RequestServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class RequestandController {

    Logger logger = LoggerFactory.getLogger(RequestandController.class);

    @Autowired
    RequestServiceImpl requestService;


    @GetMapping("/request")
    public String repuest(){
        return "/request";
    }

}
