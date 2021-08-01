package com.awei.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.Base64Codec;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: SpringbootTest
 * @author: Awei
 * @create: 2021-03-07 09:24
 **/
@SpringBootTest
public class JwtdemoApplicationTests {

    @Test
    public void testCreatToken() {
        long current = System.currentTimeMillis();
        long exp = current + 30 * 1000;

        JwtBuilder builder = Jwts.builder();
        builder.setId("A1001").setSubject("dadawei").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "wogan")
                .setExpiration(new Date(exp))
                .claim("logo", "**.jpg")


        ;

        //获取token
        String token = builder.compact();
        System.out.println(token);


        String[] split = token.split(("\\."));
        System.out.println(Base64Codec.BASE64.decodeToString(split[0]));
        System.out.println(Base64Codec.BASE64.decodeToString(split[1]));
        //加盐过 乱码
        System.out.println(Base64Codec.BASE64.decodeToString(split[2]));
    }


    @Test
    public void testParseToken() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJBMTAwMSIsInN1YiI6ImRhZGF3ZWkiLCJpYXQiOjE2MTUwODI2MjcsImV4cCI6MTYxNTA4MjY1NywibG9nbyI6IioqLmpwZyJ9.6Zx1PNHHTGx5xgWzAJEjZCK9GxG93JK1weD7_wrEs34";
        Claims claims = (Claims) Jwts.parser().setSigningKey("wogan").parse(token).getBody();
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(claims.getIssuedAt());
        System.out.println(claims.get("logo"));

    }

    @Test
    public void testTime() {
        Date d = new Date(1615133012);

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s= format.format(d);
        System.out.println(s);
    }
}
