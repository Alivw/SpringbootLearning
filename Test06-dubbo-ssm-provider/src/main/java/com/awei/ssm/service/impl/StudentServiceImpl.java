package com.awei.ssm.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.awei.ssm.mapper.StudentMapper;
import com.awei.ssm.model.Student;
import com.awei.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-01-31 15:20
 **/
@Component
@Service(interfaceClass = StudentService.class,version = "1.0.0",timeout = 15000)
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RedisTemplate<Object, Object> template;


    @Override
    public Student queryStuById(Integer id) {

        return studentMapper.selectByPrimaryKey(id);
    }

    public Integer getStuCount() {
        /*
         * 去redis 缓存查找，没有再从数据库拿
         * */

        Integer allCount = (Integer) template.opsForValue().get("stuCount");
        if (null == allCount) {

            allCount= studentMapper.queryStuCount();
            template.opsForValue().set("stuCount",allCount,15, TimeUnit.SECONDS);
        }
        return allCount;
    }

}
