package com.awei.security.mapper;

import com.awei.security.entity.SysRole;

import java.util.List;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-03 13:28
 **/
public interface RoleMapper {
    /*
    *
    * 根据用户id 查 sysrole 每个用户有多个角色
    * */
    List<SysRole> selectSysRoleByUserId(long id);
}
