package com.springboot.redids.web;

import com.springboot.redids.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
    @Autowired
    private StudentService service;

    @PutMapping(value = "/insert")
    public @ResponseBody Object insert(String key, String value) {
        service.insert(key, value);
        return "insert into redis successfully";
    }

    @GetMapping(value = "/get")
    public @ResponseBody Object get(String key) {

        String s =service.get(key);
        return "Value from redis is :"+s;
    }
}
