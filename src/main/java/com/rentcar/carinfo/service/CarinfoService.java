package com.rentcar.carinfo.service;

import com.rentcar.carinfo.model.CarinfoDTO;

import java.util.List;
import java.util.Map;

public interface CarinfoService {

    int create(CarinfoDTO dto);

    int total(Map map);

    List<CarinfoDTO> list(Map map);

    CarinfoDTO read(int carnumber);

    int update(CarinfoDTO dto);
}
