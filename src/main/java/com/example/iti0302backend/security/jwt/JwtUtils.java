package com.example.iti0302backend.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtils {

    protected static final long EXPIRATIONTIME = 1000 * 60 * 60 * 24 * 10; // 10 days

    protected static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String generateTokenFromUsername(String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("firstName", username);
        return Jwts.builder()
                .setSubject("subject")
                .addClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date((new Date()).getTime() + EXPIRATIONTIME))
                .signWith(key)
                .compact();
    }


}
