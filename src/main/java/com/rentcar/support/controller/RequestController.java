package com.rentcar.support.controller;

import com.rentcar.support.model.Request;
import com.rentcar.support.model.Surpport;
import com.rentcar.support.service.RequestServiceImpl;
import com.rentcar.support.service.SurpportServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/request")
public class RequestController {

    Logger logger = LoggerFactory.getLogger(RequestController.class);

    @Autowired
    RequestServiceImpl requestService;


    @PostMapping("/help")
    public Boolean create(@RequestBody Request request){
        logger.info(String.valueOf(request));
        return requestService.create(request);
    }

}
