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

import java.util.Collection;
import java.util.List;

/**
 * @program: jwt
 * @author: Awei
 * @create: 2021-03-07 16:23
 **/
@Service
public class UserService implements UserDetailsService {


    @Autowired
    private PasswordEncoder encoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return new User(username, encoder.encode("123"), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_admin,ROLE_nomal"));

    }
}
