package com.awei.security.provider;

import com.awei.security.dao.UserInfoDao;
import com.awei.security.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-03 11:29
 **/
@Component
public class MyUserdetailService implements UserDetailsService {

    @Autowired
    private UserInfoDao dao;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo userinfo = null;
        if (null != s) {
            userinfo = dao.getUserInfoByUsername(s);
            if (null != userinfo) {
                List<GrantedAuthority> glist = new ArrayList<>();
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + userinfo.getRole());
                glist.add(authority);
                User user = new User(userinfo.getUsername(), userinfo.getPwd(), glist);
                return user;
            }
        }
        return null;
    }

}
