package com.awei.swagger.web;

import com.awei.swagger.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: jwt
 * @author: shizuwei
 * @create: 2021-03-08 14:49
 **/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }


    @PostMapping("/getUser")
    public User getUser(User user) {
        return user;
    }
}
