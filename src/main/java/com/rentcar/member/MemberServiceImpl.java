package com.rentcar.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> 2cd4316c2f65aefb2564356757dd7f5c4e52be9c
@Service("com.rentcar.member.MemberServiceImpl")
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper mapper;

<<<<<<< HEAD
    @Override
    public List<MemberDTO> carData(String car_license) {
       return mapper.carData(car_license);
    }

}
=======

}
>>>>>>> 2cd4316c2f65aefb2564356757dd7f5c4e52be9c
