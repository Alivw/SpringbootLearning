package com.awei.security.service;

import com.awei.security.entity.SysRole;
import com.awei.security.entity.SysUser;
import com.awei.security.mapper.RoleMapper;
import com.awei.security.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-03 13:58
 **/
@Service
public class JdbcUserService implements UserDetailsService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private SysUserMapper userMapper;

    @Override

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (null != s) {
            SysUser sysUser = userMapper.selectUserByName(s);
            if (null != sysUser) {
//                根据user id 获取角色
                List<GrantedAuthority> authorityList = new ArrayList<>();
                List<SysRole> roles = roleMapper.selectSysRoleByUserId(sysUser.getId());
                for (SysRole role : roles) {
                    String name = role.getRolename();
                    authorityList.add(new SimpleGrantedAuthority("ROLE_" + name));
                }
                sysUser.setAuthorities(authorityList);
                return sysUser;
            }
        }
        return null;
    }

}
