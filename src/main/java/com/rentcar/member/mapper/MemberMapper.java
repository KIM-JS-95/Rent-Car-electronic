package com.rentcar.member;


import org.springframework.stereotype.Repository;

@Repository
public interface MemberMapper {
    MemberDTO mypage(String id);

    String reservation(String id);

    CarInfo1DTO reservation1(String id);

    CarConditionDTO reservation2(String id);
}
