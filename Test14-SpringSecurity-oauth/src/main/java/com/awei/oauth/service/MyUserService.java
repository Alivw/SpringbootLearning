package com.awei.oauth.service;

import com.awei.oauth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-06 21:19
 **/
@Service
public class MyUserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User(username, encoder.encode("123"), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_admin"));
    }

}
