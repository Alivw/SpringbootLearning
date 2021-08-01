package com.awei.security.common;

import com.awei.security.vo.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-03 15:36
 **/
@Component
public class SuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType("text/json;charset=utf-8");
        PrintWriter pw = httpServletResponse.getWriter();
        ObjectMapper om = new ObjectMapper();
        Result re = new Result();
        re.setStatus(0);
        re.setCode("1001");
        re.setMsg("登录成功");
     /*   String URL = httpServletRequest.getRequestURI();
        httpServletResponse.sendRedirect(URL);*/

        String json = om.writeValueAsString(re);
        pw.println(json);
        pw.flush();
        pw.close();
    }
}
