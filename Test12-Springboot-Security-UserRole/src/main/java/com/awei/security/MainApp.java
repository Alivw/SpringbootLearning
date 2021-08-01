package com.awei.security;

import com.awei.security.entity.SysUser;
import com.awei.security.mapper.SysUserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-03 12:35
 **/
@SpringBootApplication
@MapperScan("com.awei.security.mapper")
public class MainApp {

    @Autowired
    SysUserMapper userMapper;


    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }


//    @PostConstruct
    public void jdbcInit() {
        PasswordEncoder pe = new BCryptPasswordEncoder();
        Date date = new Date();
        List<GrantedAuthority> authorityList = new ArrayList<>();

        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + "ADMIN");
        authorityList.add(authority);
        GrantedAuthority authority1 = new SimpleGrantedAuthority("ROLE_" + "ROLE");
        authorityList.add(authority1);

        SysUser sysUser = new SysUser(1001L,
                "admin",
                pe.encode("123"),
                true, true, true,
                date, date, "管理员 ",
                true, authorityList);
        userMapper.insertSysUser(sysUser);

        authorityList = new ArrayList<>();
        authorityList.add(authority);
        SysUser sysUser1 = new SysUser(1001L,
                "lishi",
                pe.encode("123"),
                true, true, true,
                date, date, "李四",
                true, authorityList);

        userMapper.insertSysUser(sysUser1);
    }
}
