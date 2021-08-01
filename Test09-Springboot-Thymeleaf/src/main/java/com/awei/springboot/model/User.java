package com.awei.springboot.model;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-02-22 11:56
 **/
public class User {
    private String name;
    private Integer age;
    private String description;

    public User() {

    }

    public String getName() {
        
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
