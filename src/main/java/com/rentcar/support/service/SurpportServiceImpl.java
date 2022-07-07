package com.rentcar.support.service;


import com.rentcar.support.mapper.SurpportMapper;
import com.rentcar.support.model.Surpport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SurpportServiceImpl implements SurpportService {

    @Autowired
    private SurpportMapper mapper;


    @Override
    public Surpport read(String carnum) {
        return mapper.read(carnum);
    }

    @Override
    public Boolean create(Surpport carnum) {
        return mapper.create(carnum);
    }

    @Override
    public Boolean update(Surpport surpport) {
        return mapper.update(surpport);
    }

    @Override
    public List<Surpport> list(Map map) {
        return mapper.list(map);
    }


}
