package com.awei.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-07 08:31
 **/
//@Configuration
public class RedisConfig {


    @Autowired
    private RedisConnectionFactory factory;

    @Bean()
    public RedisTokenStore tokenStore() {
        return new RedisTokenStore(factory);
    }

}
