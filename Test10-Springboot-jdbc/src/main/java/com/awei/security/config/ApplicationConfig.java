package com.awei.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-03 10:35
 **/
@Component
public class ApplicationConfig {

    @Autowired
    private DataSource dataSource;

    //创建PasswordEncoder对象
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    //创建JDBCUserDetailService 对象
    public UserDetailsService jdbcUserDeatilService() {
        PasswordEncoder pe = new BCryptPasswordEncoder();
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);

        manager.createUser(User.withUsername("admin")
                .password(pe.encode("123"))
                .roles("ADMIN", "MANAGER", "USER").build()

        );
        manager.createUser(User.withUsername("zs")
                .password(pe.encode("123"))
                .roles("MANAGER", "USER").build()

        );
        manager.createUser(User.withUsername("lisi")
                .password(pe.encode("123"))
                .roles( "USER").build()
        );
        return manager;
    }
}
