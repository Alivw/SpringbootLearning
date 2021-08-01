package com.awei.security.handler;

import com.awei.security.pojo.RespBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: jwt
 * @author: Awei
 * @create: 2021-03-09 12:39
 **/
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        RespBean respBean = new RespBean(403, "权限不允许，请联系管理员", null);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.write(new ObjectMapper().writeValueAsString(respBean));
        pw.flush();
        pw.close();

    }
}
