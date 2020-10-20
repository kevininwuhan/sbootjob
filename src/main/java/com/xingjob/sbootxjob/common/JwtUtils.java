package com.xingjob.sbootxjob.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JwtUtils {

    private static final String SING = "5435UFJNDFUFF98";

    public static String getToken(Map<String,String> map){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.YEAR,35);  //设置令牌过期时间

        //创建 jwt builder
        JWTCreator.Builder builder= JWT.create();
        //payload
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });

        String token = builder.withExpiresAt(instance.getTime())//指定过期时间
                .sign(Algorithm.HMAC256(SING));

        return token;
    }
    //验证token
    public static DecodedJWT verify(String token){
        return JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
    }
}
