package com.awei.security.init;

import com.awei.security.dao.UserInfoDao;
import com.awei.security.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-03 11:24
 **/
@Component
public class JdbcInit {

    @Autowired
    private UserInfoDao userInfoDao;

//    @PostConstruct
    public void init() {

        PasswordEncoder pe = new BCryptPasswordEncoder();
        UserInfo user1 = new UserInfo();
        user1.setUsername("admin");
        user1.setPwd(pe.encode("123"));
        user1.setRole("admin");

        UserInfo user2 = new UserInfo();
        user2.setUsername("guest");
        user2.setPwd(pe.encode("123"));
        user2.setRole("guest");


        userInfoDao.save(user1);
        userInfoDao.save(user2);

    }
}
