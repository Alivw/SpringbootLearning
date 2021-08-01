package com.awei.security.mapper;

import com.awei.security.entity.SysUser;
import org.springframework.stereotype.Repository;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-03 12:26
 **/
@Repository
public interface SysUserMapper {

    /*
     * 添加用户
     * */
    int insertSysUser(SysUser user);

    /*
    * 根据用户名称查询用户
    * */
    SysUser selectUserByName(String name);


}
