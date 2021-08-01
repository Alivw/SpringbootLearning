package com.springboot.redids.service.impl;

import com.springboot.redids.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    @Override
    public void insert(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String get(String key) {
        String result =(String)redisTemplate.opsForValue().get(key);
        return result;
    }
}
