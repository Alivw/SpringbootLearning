package com.awei.security.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-03 14:10
 **/
@RestController

public class UserController {


    @GetMapping("/access/user")
    public String User() {
        return "User 页面";
    }


    @GetMapping("/access/admin")
    public String Admin() {
        return "admin 专属页面";
    }
}
