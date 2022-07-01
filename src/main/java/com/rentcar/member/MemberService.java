package com.rentcar.member;

import org.springframework.stereotype.Service;

import java.util.List;

public interface MemberService {


    List<MemberDTO> carData(String car_license);
}