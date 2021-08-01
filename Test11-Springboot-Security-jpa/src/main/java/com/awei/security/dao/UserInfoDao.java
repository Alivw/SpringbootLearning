package com.awei.security.dao;

import com.awei.security.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-03 11:16
 **/
public interface UserInfoDao extends JpaRepository<UserInfo, Long> {

    UserInfo getUserInfoByUsername(String username);

}
