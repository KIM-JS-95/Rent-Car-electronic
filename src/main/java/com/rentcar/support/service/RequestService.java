package com.rentcar.support.service;

import com.rentcar.support.model.Request;
import com.rentcar.support.model.Surpport;

import java.util.List;
import java.util.Map;

public interface RequestService {


    Surpport read(String carnum);
    Boolean create(Request request);
    Boolean update(Request request);
    List<Surpport> list(Map map);

}
