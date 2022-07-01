package com.rentcar.CarImformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.rentcar.CarImformation.CartServiceImpl")
public class CarServiceImpl implements CarService{

    @Autowired
    private CarMapper mapper;
}

