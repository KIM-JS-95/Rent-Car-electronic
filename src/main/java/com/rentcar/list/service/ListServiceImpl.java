package com.rentcar.list.service;


import com.rentcar.list.mapper.ListMapper;
import com.rentcar.list.model.ListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("com.rentcar.list.ListServiceImpl")
public class ListServiceImpl implements ListService {

    @Autowired
    private ListMapper mapper;

    @Override
    public List<ListDTO> list(Map map) {
        return mapper.list(map);
    }

    @Override
    public int total(Map map) {
        return mapper.total(map);
    }

    @Override
    public int create(ListDTO dto) {
        return mapper.create(dto);
    }

    @Override
    public int upViewcnt(int listno) {
        return mapper.upViewcnt(listno);
    }

    @Override
    public ListDTO read(int listno) {
        return mapper.read(listno);
    }

    @Override
    public int update(ListDTO dto) {
        return mapper.update(dto);
    }

    @Override
    public int passCheck(Map map) {
        return mapper.passCheck(map);
    }

    @Override
    public int delete(int listno) {
        return mapper.delete(listno);
    }

    @Override
    public ListDTO readReply(int listno) {
        return mapper.readReply(listno);
    }

    @Override
    public int upAnsnum(Map map) {
        return mapper.upAnsnum(map);
    }

    @Override
    public int createReply(ListDTO dto) {
        return mapper.createReply(dto);
    }

    @Override
    public int checkRefnum(int bbsno) {
        return mapper.checkRefnum(bbsno);
    }
}
