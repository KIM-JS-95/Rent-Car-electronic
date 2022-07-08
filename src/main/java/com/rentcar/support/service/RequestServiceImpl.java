package com.rentcar.support.service;


import com.rentcar.support.mapper.RequestMapper;
import com.rentcar.support.mapper.SurpportMapper;
import com.rentcar.support.model.Request;
import com.rentcar.support.model.State;
import com.rentcar.support.model.Surpport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestMapper mapper;

    /*
    request => 요청중
    accept => 헬퍼 준비중
    on going => 이동중
    done => 처리 완료
     */

    @Override
    public Surpport read(String carnum) {
        return mapper.read(carnum);
    }

    @Override
    public Boolean create(Request request) {
        request.setState(State.valueOf("request"));
        return mapper.create(request);
    }

    @Override
    public Boolean update(Request request) {
        return mapper.update(request);
    }

    @Override
    public List<Surpport> list(Map map) {
        return mapper.list(map);
    }


}
