package com.example.demo.controller;

import com.example.demo.controller.model.Awei;
import com.example.demo.controller.model.Calinda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {
    @Value("${name}")
    private String name;
    @Value("${age}")
    private int age;
    @Autowired
    private Awei awei;
    @Autowired
    private Calinda cal;
    @RequestMapping(value ="/say")
    public @ResponseBody String say() {

        return "name"+"----"+name+"   age"+"----"+age;
    }
    @RequestMapping(value = "/mapSay")
    public @ResponseBody Map<String,Object> MapString(){
        Map<String,Object> retMap =new HashMap<String,Object>();
        retMap.put("message", "Hello world!");
        retMap.put("aweiName", awei.getName());
        retMap.put("aweiAge", awei.getAge());
        retMap.put("calindaName", cal.getName());
        retMap.put("calindaAge", cal.getAge());
        return retMap;
    }


}
