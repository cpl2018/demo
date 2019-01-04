package com.imooc.service;

import com.imooc.repository.GirlRepository;
import com.imooc.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;
    @Transactional
    public  void girlsaveTwo(){
        Girl girl1=new Girl();
        girl1.setAge(36);
        girl1.setCupSize("F");
        Girl girl2=new Girl();
        girl2.setAge(16);
        girl2.setCupSize("C");
        girlRepository.save(girl1);
        girlRepository.save(girl2);
    }

}
