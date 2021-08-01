package com.awei.lezijie.config;

import com.awei.lezijie.handler.MyAccessDeniedHandler;
import com.awei.lezijie.handler.MyAuthenticationFailHandler;
import com.awei.lezijie.handler.MyAuthenticationSuccessHandler;
import com.awei.lezijie.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-05 18:38
 **/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    MyAccessDeniedHandler accessDeniedHandler;

    @Autowired
    DataSource dataSource;
    @Autowired
    PersistentTokenRepository persistentTokenRepository;


    @Autowired
    UserDetailServiceImpl userDetailsService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/showLogin")
                //表单验证提交的接口
                .loginProcessingUrl("/login")
                .successForwardUrl("/toMain")
                .failureForwardUrl("/toError")

               /* .successHandler(new MyAuthenticationSuccessHandler("/main.html"))
            .failureHandler(new MyAuthenticationFailHandler("/error.html"))*/
        ;

//        http.csrf().disable();

        http.authorizeRequests().antMatchers("/login.html").permitAll()
                .antMatchers("/error.html").permitAll()
                .antMatchers("/img/**").permitAll()
                .antMatchers("/showLogin").permitAll()
//                .antMatchers("/main.html").hasIpAddress("192.168.0.106")
                .anyRequest().authenticated();

        http.rememberMe().tokenRepository(persistentTokenRepository)
                //超时时间
                .tokenValiditySeconds(10)
                .userDetailsService(userDetailsService)
        ;

        //异常处理
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl j = new JdbcTokenRepositoryImpl();
        //设置数据源
        j.setDataSource(dataSource);
        //启动时 建表
//        j.setCreateTableOnStartup(true);
        return j;
    }

}
