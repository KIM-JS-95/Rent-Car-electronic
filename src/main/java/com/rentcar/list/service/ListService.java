package com.rentcar.list.service;

import com.rentcar.list.ListDTO;

import java.util.List;
import java.util.Map;

public interface ListService {
    List<ListDTO> list(Map map);
    int total(Map map);

    int create(ListDTO dto);
    int upViewcnt(int listno);
    ListDTO read(int listno);
    int update(ListDTO dto);
    int passCheck(Map map);
    int delete(int listno);
    ListDTO readReply(int listno);
    int upAnsnum(Map map);
    int createReply(ListDTO dto);

    int checkRefnum(int bbsno);
}
