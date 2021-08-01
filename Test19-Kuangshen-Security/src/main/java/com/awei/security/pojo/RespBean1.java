package com.awei.security.pojo;

/**
 * @program: jwt
 * @author: Awei
 * @create: 2021-03-09 12:21
 **/
public class RespBean1 {

    private long code;
    private String msg;
    private Object obj;


    public static RespBean1 success(long code, String msg) {
        return new RespBean1(code, msg, null);
    }

    public static RespBean1 success(long code, String msg, Object obj) {
        return new RespBean1(code, msg, obj);
    }

    public static RespBean1 error(long code, String msg) {
        return new RespBean1(code, msg, null);
    }

    public static RespBean1 error(long code, String msg, Object obj) {
        return new RespBean1(code, msg, obj);
    }


    public RespBean1() {
    }

    public RespBean1(long code, String msg, Object obj) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
