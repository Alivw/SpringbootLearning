package com.awei.security.pojo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @program: jwt
 * @author: Awei
 * @create: 2021-03-07 16:26
 **/
public class User implements UserDetails {
    private String username;

    private String password;

    private List<GrantedAuthority> authorityList;


    public User(String username, String password, List<GrantedAuthority> authorityList) {
        this.username = username;
        this.password = password;
        this.authorityList = authorityList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
