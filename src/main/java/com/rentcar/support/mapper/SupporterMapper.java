package com.rentcar.support.mapper;


import com.rentcar.support.model.Supporter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SupporterMapper {

    Supporter read(String carnum);

    Boolean create(Supporter carnum);

    Boolean update(Supporter surpport);

    List<Supporter> list(Map map);

    int total(Map map);

    Boolean delete(int no);
}
