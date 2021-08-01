package com.awei.security.config;

import com.awei.security.handler.MyAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @program: jwt
 * @author: Awei
 * @create: 2021-03-09 10:41
 **/
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/","/toLogin","/css/**","/js/**").permitAll()
                .antMatchers("/level1/**").hasAnyAuthority("vip1")
                .antMatchers("/level2/**").hasAnyAuthority("vip2")
                .antMatchers("/level3/**").hasAnyAuthority("vip3")
                .anyRequest().authenticated()
                //自定义登录页面
                .and().formLogin().loginPage("/toLogin")
                //和表单请求地址一样
                .loginProcessingUrl("/user/login")
                .and().csrf().disable();

        http.logout().logoutSuccessUrl("/");
        //异常处理
        http.exceptionHandling()
                .accessDeniedHandler(myAccessDeniedHandler);

    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
