package com.awei.lezijie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-05 18:40
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("==================================");
        if (!"admin".equals(s)) {
            throw new UsernameNotFoundException("用户不存在");
        }
        String pwd = encoder.encode("123");
        User user = new User(s, pwd, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_nomal,ROLE_admin"));
        return user;

    }

}
