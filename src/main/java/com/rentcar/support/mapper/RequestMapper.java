package com.rentcar.support.mapper;


import com.rentcar.support.model.Request;
import com.rentcar.support.model.Surpport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RequestMapper {
    // reard
    Surpport read(String carnum);

    Boolean create(Request request);

    Boolean update(Request request);

    List<Surpport> list(Map map);

}
