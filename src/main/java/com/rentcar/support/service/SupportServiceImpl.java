package com.rentcar.support.service;


import com.rentcar.support.mapper.SupporterMapper;
import com.rentcar.support.model.Supporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SupportServiceImpl implements SurpportService {

    @Autowired
    private SupporterMapper mapper;


    @Override
    public Supporter read(String carnum) {
        return mapper.read(carnum);
    }

    @Override
    public Boolean create(Supporter carnum) {
        return mapper.create(carnum);
    }

    @Override
    public Boolean update(Supporter surpport) {
        return mapper.update(surpport);
    }

    @Override
    public List<Supporter> list(Map map) {
        return mapper.list(map);
    }


    public int total(Map map) {
        return mapper.total(map);
    }

    @Override
    public Boolean delete(int no) {
        return mapper.delete(no);
    }
}
