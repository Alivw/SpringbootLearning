package com.awei.security.vo;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-03 15:54
 **/
public class Result {
    private int status;
    private String code;
    private String msg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
