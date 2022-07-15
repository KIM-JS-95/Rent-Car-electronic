package com.rentcar.support.controller;

import com.rentcar.support.model.Surpport;
import com.rentcar.support.service.SurpportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/surpport")
public class SurpportController {

    @Autowired
    SurpportServiceImpl serpportService;

    @GetMapping("/read")
    public Surpport sup(){
        String  carnum = "12가1234";

        return serpportService.read(carnum);
    }

    @PostMapping("/create")
    public Boolean create(@RequestBody Surpport surpport){

        return serpportService.create(surpport);
    }

    @PostMapping("/update")
    public Boolean update(@RequestBody Surpport surpport){

        return serpportService.update(surpport);
    }

    @GetMapping("/list")
    public List<Surpport> list(HttpServletRequest request){

        String carnum = "";

        Map map = new HashMap();
        map.put("carnum", carnum);


        return serpportService.list(map);
    }
}
