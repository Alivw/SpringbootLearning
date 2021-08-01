package com.springboot.jsp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @RequestMapping(value = "/hello")
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("data", "Hello Springboot!");
        mv.setViewName("say");

        return mv;
    }

    @RequestMapping(value = "/test")
    public @ResponseBody String test() {
        return "Hello world";
    }
}
