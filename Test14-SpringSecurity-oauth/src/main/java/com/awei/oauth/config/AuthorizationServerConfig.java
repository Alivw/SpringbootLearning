package com.awei.oauth.config;

import com.awei.oauth.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-06 21:25
 **/
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private PasswordEncoder encoder;

//    @Autowired
//    private RedisTokenStore redisTokenStore;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private MyUserService userService;


    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

//    @Autowired
//    private JwtTokenEnhancer jwtTokenEnhancer;


    @Autowired
    private JwtTokenStore tokenStore;


    @Autowired
    private JwtTokenEnhancer jwtTokenEnhancer;


    /////////////////////////////////
    /*@Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MyUserService userService;
    @Autowired
    private AuthenticationManager manager;



    @Autowired
    private JwtTokenStore tokenStore;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;


    @Autowired
    private JwtTokenEnhancer jwtTokenEnhancer;*/
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain chan = new TokenEnhancerChain();
        List<TokenEnhancer> delegates = new ArrayList<>();
        delegates.add(jwtTokenEnhancer);
        delegates.add(jwtAccessTokenConverter);
        chan.setTokenEnhancers(delegates);

        endpoints.authenticationManager(manager).userDetailsService(userService)
                .tokenStore(tokenStore)
                .accessTokenConverter(jwtAccessTokenConverter)
        .tokenEnhancer(chan)
        ;


    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("admin")
                .secret(encoder.encode("112233"))

                .redirectUris("http://www.baidu.com")
                .scopes("all")
                .accessTokenValiditySeconds(60)
                /*
                 * authorization_code:授权码模式
                 * password:密码模式
                 * */
                .authorizedGrantTypes("authorization_code", "password","refresh_token")
        ;

    }
}
