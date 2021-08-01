package com.awei.security.entity;

import org.omg.CORBA.portable.IDLEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.management.loading.PrivateClassLoader;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-03 12:17
 **/
public class SysUser implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private boolean isenable;
    private boolean islock;
    private boolean iscredentials;
    private Date createtime;
    private Date logintime;
    private String realname;
    private boolean isExpired;
    private List<GrantedAuthority> authorities;
    public SysUser() {
    }

    public SysUser(Long id, String username, String password, boolean isenable, boolean islock, boolean iscredentials, Date createtime, Date logintime, String realname, boolean isExpired, List<GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isenable = isenable;
        this.islock = islock;
        this.iscredentials = iscredentials;
        this.createtime = createtime;
        this.logintime = logintime;
        this.realname = realname;
        this.isExpired = isExpired;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
        return isExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return islock;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return iscredentials;
    }

    @Override
    public boolean isEnabled() {
        return isenable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsenable() {
        return isenable;
    }

    public void setIsenable(boolean isenable) {
        this.isenable = isenable;
    }

    public boolean isIslock() {
        return islock;
    }

    public void setIslock(boolean islock) {
        this.islock = islock;
    }

    public boolean isIscredentials() {
        return iscredentials;
    }

    public void setIscredentials(boolean iscredentials) {
        this.iscredentials = iscredentials;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
