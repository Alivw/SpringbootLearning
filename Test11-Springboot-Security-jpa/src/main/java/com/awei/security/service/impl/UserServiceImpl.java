package com.awei.security.service.impl;

import com.awei.security.dao.UserInfoDao;
import com.awei.security.entity.UserInfo;
import com.awei.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-03 11:18
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoDao dao;
    @Override
    public UserInfo getUserByUsername(String Username) {
        return dao.getUserInfoByUsername(Username);
    }
}
