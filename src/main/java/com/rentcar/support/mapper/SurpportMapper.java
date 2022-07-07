package com.rentcar.support.mapper;


import com.rentcar.support.model.Surpport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SurpportMapper {
    // reard
    Surpport read(String carnum);

    Boolean create(Surpport carnum);

    Boolean update(Surpport surpport);

    List<Surpport> list(Map map);

}
