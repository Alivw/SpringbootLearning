package com.awei.security.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: jwt
 * @author: Awei
 * @create: 2021-03-09 14:36
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {

    private long code;
    private String msg;
    private Object obj;

    public static RespBean success(long code, String msg) {
        return new RespBean(code, msg, null);
    }

    public static RespBean success(long code, String msg, Object obj) {
        return new RespBean(code, msg, obj);
    }

    public static RespBean error(long code, String msg) {
        return new RespBean(code, msg, null);
    }

    public static RespBean error(long code, String msg, Object obj) {
        return new RespBean(code, msg, obj);
    }


}
