package com.springboot.mybatis.service.impl;

import com.springboot.mybatis.mapper.StudentMapper;
import com.springboot.mybatis.model.Student;
import com.springboot.mybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student queryStudentById(Integer id) {

        return studentMapper.selectByPrimaryKey(id);
    }
}
