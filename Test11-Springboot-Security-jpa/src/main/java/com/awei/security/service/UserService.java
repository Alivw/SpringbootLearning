package com.awei.security.service;

import com.awei.security.entity.UserInfo;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-03 11:18
 **/

public interface UserService {
    UserInfo getUserByUsername(String Username);

}
