package com.awei.lezijie.handler;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-06 08:39
 **/
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {



    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        //设置响应状态码
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        httpServletResponse.setHeader("Content-Type", "application/json;charset=utf-8");
        PrintWriter pw = httpServletResponse.getWriter();
        pw.write("{\"status\":\"error\",\"msg\":\"权限不足\"}");
        pw.flush();
        pw.close();
    }
}
