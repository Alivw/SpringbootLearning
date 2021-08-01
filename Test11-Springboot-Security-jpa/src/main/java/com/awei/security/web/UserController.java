package com.awei.security.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-03 11:39
 **/
@RestController
public class UserController {


    @GetMapping("/hello/admin")
    @PreAuthorize("hasAnyRole('admin')")
    public String helloAdmin() {
        return "admin 专属页面";
    }

    @GetMapping("/hello/guest")
    @PreAuthorize("hasAnyRole('guest','admin')")
    public String helloNomal() {
        return "guest nomal 都能访问";
    }
}
