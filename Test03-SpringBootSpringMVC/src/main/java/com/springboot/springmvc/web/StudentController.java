package com.springboot.springmvc.web;

import com.springboot.springmvc.model.Student;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController  //相当于 @Controller +@ResponsBody
public class StudentController {
    @RequestMapping(value = "/student")
    public Object student() {
        Student student = new Student();
        student.setName("shizuwei");
        student.setAge(19);
        student.setId(1001);
        return student;
    }


    //    该方法支持post get 请求方式
//    @RequestMapping(value = "/queryStudentByid")
    @RequestMapping(value = "/queryStudentByid", method = {RequestMethod.GET, RequestMethod.POST})
    public Object queryStudentByid(Integer id) {
        Student s = new Student();
        s.setId(id);
        return s;
    }

    @GetMapping(value = "/queryStudentByid2")
    public Object queryStudentByid2() {
        //该注解在查询时常用
        return "Only get method";
    }

    @PostMapping(value = "/insert")
    public Object insert() {
        // 新增
        return "insert success";
    }

    @PutMapping(value = "/update")
    public Object update() {
        //修改
        return "update success";
    }

    @DeleteMapping(value = "/delete")
    public Object delete() {
        return "delete success";
    }


    /*
     *
     * RestFul 请求风格
     *
     * */

    @RequestMapping(value = "/restFul/detail/{id}/{age}")
    public Object restFulTest01(@PathVariable("id") Integer id,
                                @PathVariable("age") Integer age
                                ) {
        Student s = new Student();
        s.setId(id);
        s.setAge(age);
        return s;
    }
}
