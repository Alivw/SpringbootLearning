package com.awei.ssm.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.awei.ssm.model.Student;
import com.awei.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-01-31 15:06
 **/

@Controller
public class StudentController {


    @Reference(interfaceClass = StudentService.class, version = "1.0.0", check = false)
    private StudentService studentService;

    @GetMapping("/getStuInfo/{id}")
    public String getStuInfo(@PathVariable("id") Integer id, Model model) {

        Student stu = studentService.queryStuById(id);
        model.addAttribute("stu", stu);
        return "stuDetail";
    }

    @RequestMapping(value = "/getStuCount")
    public @ResponseBody
    Object getStuCount() {
        return studentService.getStuCount();
    }
}
