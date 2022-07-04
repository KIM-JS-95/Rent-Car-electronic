package com.rentcar.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.rentcar.member.MemberServiceImpl")
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper mapper;


//    @Override
//    public MemberDTO mypage(String id) {
//        return mapper.mypage(id);
//    }
}
