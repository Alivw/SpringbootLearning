package com.springboot.mybatis.web;

import com.springboot.mybatis.model.Student;
import com.springboot.mybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @RequestMapping(value = "/student")
    public @ResponseBody
    Student queryStudentById(Integer id) {
        Student stu = service.queryStudentById(id);
        return stu;
    }
}
