package com.rentcar.carinfo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface CarinfoService {

    int create(CarinfoDTO dto);

    int total(Map map);

    List<CarinfoDTO> list(Map map);

    CarinfoDTO read(int carnumber);

    int update(CarinfoDTO dto);
}
