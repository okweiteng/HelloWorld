package com.wt.study.springboot.validation.application.service;


import com.wt.study.springboot.validation.domain.param.PersonParams;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
public class PersonAppService {
    public void findById(Long id) {

    }

    public void createPerson(@Valid PersonParams params) {
        System.out.println("创建成功");
    }
}
