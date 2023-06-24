package edu.ktp.utils;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.UUID;

@Slf4j
public class JwtUtil {
    private static long time = 1000L *60*60*24*30;   // token 有效期为一个月
    private static String signature = "admin";
//    private static long time = 1000;

    // 生成token ，三个参数是我实体类的字段，可根据自身需求来传，一般只需要用户id即可
    public static String createJwtToken(String accountName,String password){
        JwtBuilder builder = Jwts.builder();
        String jwtToken = builder
                // header
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                // payload 载荷
                .claim("username", accountName)
                .claim("password", password)
                .setExpiration(new Date(System.currentTimeMillis() + time))
                // signature 签名信息
                .signWith(SignatureAlgorithm.HS256, signature)
                // 用.拼接
                .compact();
        return jwtToken;
    }

    // 验证 token 是否还有效，返回具体内容
    public static Claims checkToken(String token){
        if (token == null){
            return null;
        }
        JwtParser parser = Jwts.parser();
        try {
            Jws<Claims> claimsJws = parser.setSigningKey(signature).parseClaimsJws(token);
            Claims claims = claimsJws.getBody();
            // 如果解析 token 正常，返回 claims
            return claims;
        } catch (Exception e) {
            // 如果解析 token 抛出异常，返回 null
            e.printStackTrace();
            return null;
        }
    }
}
