package com.awei.security.config;

import com.awei.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @program: jwt
 * @author: Awei
 * @create: 2021-03-07 16:12
 **/
@Configuration
@EnableAuthorizationServer

public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenStore jwtTokenStore;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
       /* endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userService);*/


        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userService)
                //????????????????????????
                .tokenStore(jwtTokenStore)
                .accessTokenConverter(jwtAccessTokenConverter);

    }



    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("admin")
                .secret(encoder.encode("112233"))

                .redirectUris("http://localhost:8081/login")
                .scopes("all")
                .accessTokenValiditySeconds(60)
                .autoApprove(true)
                /*
                 * authorization_code:???????????????
                 * password:????????????
                 * */
                .authorizedGrantTypes("authorization_code", "password", "refresh_token")
        ;

    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // ??????????????????????????????????????????????????????????????????
        security.tokenKeyAccess("isAuthenticated()");

    }
}
