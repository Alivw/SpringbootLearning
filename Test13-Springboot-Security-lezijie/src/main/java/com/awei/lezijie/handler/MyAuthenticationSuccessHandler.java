package com.awei.lezijie.handler;

import com.sun.org.apache.xerces.internal.impl.dv.xs.AnyURIDV;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-05 19:36
 **/

public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    private String Url;

    public MyAuthenticationSuccessHandler(String url) {
        Url = url;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.sendRedirect(Url);

    }
}
