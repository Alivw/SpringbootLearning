package com.awei.java.service.impl;


import com.awei.java.service.Service;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-02-01 11:28
 **/

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    @Override
    public String sayHello() {
        return "Hello Springboot!";
    }
}
