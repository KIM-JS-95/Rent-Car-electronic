package com.rentcar.kakao.service;

import com.rentcar.kakao.Model.Store;
import com.rentcar.kakao.Model.StoreDTO;
import com.rentcar.kakao.mapper.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StoreServiceImpl implements StoreService{


    @Autowired
    private StoreMapper storeMapper;

    // TODO: 사용자 기준 2km 이내의 편의 시설 을 계산하려면 만하탄 알고리즘을 사용해야할까?
    public List<Store> stores(Map<String, String> map){

        return storeMapper.stores(map);
    }

    @Override
    public Boolean create(Store store) {
        return storeMapper.create(store);
    }
}
