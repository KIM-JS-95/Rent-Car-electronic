package com.rentcar.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @Autowired
    @Qualifier("com.rentcar.member.MemberServiceImpl")
    private MemberService service;

    @GetMapping("/{id}")
    public String hello(@PathVariable("id") int id){

        return id + "입니다.";
    }

    @GetMapping("/mypage")
    public String mypage(){
//        HttpSession session, Model model
        return "/mypage";
    }








}