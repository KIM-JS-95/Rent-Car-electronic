package com.rentcar.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {


    @Autowired
    @Qualifier("com.rentcar.member.MemberServiceImpl")
    private MemberService service;



}
