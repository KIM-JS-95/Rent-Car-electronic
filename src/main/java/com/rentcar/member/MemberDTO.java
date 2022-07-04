package com.rentcar.member;

import lombok.Data;

@Data
public class MemberDTO {

    private String id;
    private String passwd;
    private String mname;
    private String phone;
    private String email;
    private String license;
    private String carnumber;

    private car_info1DTO carIndto;
    private carConditionDTO carCdto;

}
