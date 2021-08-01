package com.awei.security.entity;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-03 13:29
 **/
public class SysRole {
    private Long id;
    private String rolename;
    private String rolememo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRolememo() {
        return rolememo;
    }

    public void setRolememo(String rolememo) {
        this.rolememo = rolememo;
    }
}
