package com.awei.lezijie.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-05 19:38
 **/
public class MyAuthenticationFailHandler implements AuthenticationFailureHandler {

    private String url;

    public MyAuthenticationFailHandler(String url) {
        this.url = url;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        httpServletResponse.sendRedirect(url);
    }
}
