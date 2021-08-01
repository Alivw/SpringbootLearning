package com.awei.springboot.web;

import com.awei.springboot.model.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-02-22 11:28
 **/
@Controller
public class ThymeleafController {


    @RequestMapping("/hello/thymeleaf")
    public String massage(Model model) {
        model.addAttribute("message", "Welcome to use thymeleaf");
        return "index";
    }


    @RequestMapping("/user/detail")
    public String userDetail(Model model) {
        User user = new User();
        user.setAge(19);
        user.setName("Dadawei");
        user.setDescription("一个帅气的阳光大男孩");
        model.addAttribute(user);
        return "index";
    }

    @RequestMapping("/url")
    public String url(Model model) {
        model.addAttribute("username", "lishsi");
        model.addAttribute("id", "1001");
        model.addAttribute("age", 18);

        return "url";
    }

    @RequestMapping("/eachList")
    public String eachList(Model model) {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("余" + i + "凡");
            user.setAge(10 + i);
            user.setDescription("我是第" + i + "个一凡");
            userList.add(user);
        }
        model.addAttribute("users", userList);
        return "each";
    }

    @RequestMapping("eachMap")
    public String eachMap(Model model) {
        Map<Integer, Object> userMaps = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("余" + i + "凡");
            user.setAge(10 + i);
            user.setDescription("我是第" + i + "个一凡");
            userMaps.put(i, user);
        }
        model.addAttribute("userMaps", userMaps);
        return "each";
    }
}
