package com.rentcar.carinfo.mapper;

import com.rentcar.carinfo.model.CarinfoDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


public interface CarinfoMapper {

    int create(CarinfoDTO dto);

    int total(Map map);
    List<CarinfoDTO> list(Map map);
    CarinfoDTO read(int carnumber);
    int update(CarinfoDTO dto);


}
