package com.rentcar.support.service;


import com.rentcar.support.mapper.RequestMapper;
import com.rentcar.support.model.Request;
import com.rentcar.support.model.Supporter;
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
    public Supporter read(String carnum) {
        return mapper.read(carnum);
    }

    @Override
    public Boolean create(Request request) {
        // TODO: 요정정보 저장 및 상태 정보 저장
        return mapper.create(request);
    }

    @Override
    public Boolean update(Request request) {
        return mapper.update(request);
    }

    @Override
    public List<Supporter> list(Map map) {
        return mapper.list(map);
    }


    //TODO: 실시간으로 상태를 업데이트 해줘야한다.
    @Override
    public Boolean update_state(Map<String, String> map) {
        String carnum = map.get("carnum");
        String state = map.get("state");

        return mapper.update_state(map);
    }


    @Override
    public Boolean readmock(String carnum) {
        return mapper.readmock(carnum);
    }


}
