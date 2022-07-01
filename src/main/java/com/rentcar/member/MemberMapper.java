package com.rentcar.member;

import org.springframework.stereotype.Repository;

import java.util.List;


public interface MemberMapper {


    List<MemberDTO> carData(String car_license);
}