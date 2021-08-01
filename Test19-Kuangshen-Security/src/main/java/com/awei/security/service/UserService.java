package com.awei.security.service;

import com.awei.security.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: jwt
 * @author: Awei
 * @create: 2021-03-09 11:14
 **/
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("root".equals(username)) {
            User user = new User(username, encoder.encode("123"), AuthorityUtils.commaSeparatedStringToAuthorityList("vip1,vip2,vip3"));

            return user;

        }
        if ("shizuwei".equals(username)) {
            User user = new User(username, encoder.encode("123"), AuthorityUtils.commaSeparatedStringToAuthorityList("vip1,vip2"));
            return user;
        }
        if ("guest".equals(username)) {
            User user = new User(username, encoder.encode("123"), AuthorityUtils.commaSeparatedStringToAuthorityList("vip1"));
           /* List<GrantedAuthority> authorityList = (List<GrantedAuthority>) user.getAuthorities();
            for (GrantedAuthority g : authorityList) {
                System.out.println(g);
            }*/
            return user;
        }
        throw new UsernameNotFoundException("用户不存在");
    }

}
