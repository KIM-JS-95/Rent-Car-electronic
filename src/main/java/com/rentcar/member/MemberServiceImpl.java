package com.rentcar.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("com.rentcar.member.MemberServiceImpl")
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper mapper;

    @Override
    public List<MemberDTO> carData(String car_license) {
       return mapper.carData(car_license);
    }

}