package com.rentcar.member;



//@Service
public interface MemberService {

    MemberDTO mypage(String id);

    String reservation(String id);

    CarInfo1DTO reservation1(String id);

    CarConditionDTO reservation2(String id);
}
