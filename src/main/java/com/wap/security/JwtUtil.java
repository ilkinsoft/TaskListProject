package com.wap.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

    private static String secret="ourSecret";


    public static UserJwt validate(String token) {
        UserJwt jwtUser = null;

        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser =(UserJwt) body.get("data");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return jwtUser;
    }

    public static String generate(UserJwt userJwt) {
        Claims claims = Jwts.claims().setSubject(userJwt.getEmail());
        claims.put("data", userJwt);

        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

}