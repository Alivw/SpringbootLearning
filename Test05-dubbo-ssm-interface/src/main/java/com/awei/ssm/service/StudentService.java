package com.awei.ssm.service;

import com.awei.ssm.model.Student;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-01-31 15:09
 **/

public interface StudentService {


    Student queryStuById(Integer id);

    Integer getStuCount();
}
