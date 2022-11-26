package com.example.iti0302backend.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtils {

    private static final long EXPIRATIONTIME = 1000 * 60 * 60 * 24 * 10; // 10 days
    LocalDateTime currentTime = LocalDateTime.now();
    private static final byte[] keyBytes = Decoders.BASE64.decode("c29tZSBraW5kIG9mIHJhbmRvbSBzZWNyZXQdrfgyuhjoiklkmjnhbgfdfghj=");

    private static final Key key = Keys.hmacShaKeyFor(keyBytes);

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
