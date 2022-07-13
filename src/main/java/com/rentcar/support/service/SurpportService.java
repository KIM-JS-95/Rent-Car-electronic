package com.rentcar.support.service;

import com.rentcar.support.model.Supporter;

import java.util.List;
import java.util.Map;

public interface SurpportService {


    Supporter read(String carnum);
    Boolean create(Supporter carnum);
    Boolean update(Supporter carnum);
    List<Supporter> list(Map map);
    int total(Map map);

    Boolean delete(int no);
}
