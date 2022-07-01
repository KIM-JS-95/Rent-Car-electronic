package com.rentcar.member;


import lombok.Data;

@Data
public class MemberDTO {

    private String id;
    private String passwd;
    private String mname;
    private String phone;
    private String email;
}
