package com.awei.lezijie.web;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-05 19:16
 **/
@Controller
public class UserController {


    @RequestMapping("/toMain")
    @Secured("ROLE_admin")
    public String toMain() {
        return "redirect:main.html";
    }

    @RequestMapping("/Hello")
    @PreAuthorize("hasAnyRole('admin')")
    public @ResponseBody
    String hello() {
        return "Hello index";
    }

    @RequestMapping("/toError")
    public String toError() {
        return "redirect:error.html";
    }

    @RequestMapping("/demo")
    public String demo() {
        return "Demo";
    }


    @RequestMapping("/showLogin")
    public String showLogin() {
        return "login";
    }
}
