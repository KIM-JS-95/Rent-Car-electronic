package com.rentcar.support.mapper;


import com.rentcar.support.model.Request;
import com.rentcar.support.model.Supporter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/*
support_log 테이블로 저장
 */
@Repository
public interface RequestMapper {

    Supporter read(String carnum);

    Boolean create(Request request);

    Boolean update(Request request);

    List<Supporter> list(Map map);

    Boolean update_state(Map map);

    Boolean readmock(String carnum);

}
