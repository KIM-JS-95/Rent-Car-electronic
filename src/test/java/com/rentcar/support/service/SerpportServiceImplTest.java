package com.rentcar.support.service;

import com.rentcar.support.mapper.SurpportMapper;
import com.rentcar.support.model.Surpport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SerpportServiceImplTest {


    @Autowired
    private SurpportMapper mapper;

    @Test
    public void support_find(){

        Surpport surpport = new Surpport();

        String carnum = "12가1234";
        surpport.setCarnum(carnum);

        Surpport su =mapper.read(carnum);
        System.out.println(su);
    }
}