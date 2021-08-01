package com.awei.security.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-03 10:52
 **/
@RestController
public class UserController {

    @GetMapping("/hello")
    public String Hello() {
        return "Hello jdbcUserDetialService";
    }
}
