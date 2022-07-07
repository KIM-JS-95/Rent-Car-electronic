package com.rentcar.support.model;

import lombok.Data;


/*
서포트 차량 테이블
 */
@Data
public class Surpport {

    /*
     견인 및 이동식 충전 서비스 지원
     */
    private String carnum;

    /*
    현재 위치(x,y) 및 요청 좌표(rx,ry)
     */
    private String x; // not  null
    private String y;

    private String rx;
    private String ry;

}
