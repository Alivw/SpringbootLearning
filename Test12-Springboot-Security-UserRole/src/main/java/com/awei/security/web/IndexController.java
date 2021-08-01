package com.awei.security.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-03 14:34
 **/
@Controller

public class IndexController {


    @GetMapping("/index")
    public String index() {
        return "forward:/index.html";
    }
}
