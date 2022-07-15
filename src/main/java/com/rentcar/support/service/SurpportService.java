package com.rentcar.support.service;

import com.rentcar.support.model.Surpport;

import java.util.List;
import java.util.Map;

public interface SurpportService {


    Surpport read(String carnum);
    Boolean create(Surpport carnum);
    Boolean update(Surpport carnum);
    List<Surpport> list(Map map);

}
