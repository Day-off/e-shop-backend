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

    private JwtUtils() {

    }

    protected static final long EXPIRATIONTIME = 864000000; // 10 days

    protected static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String generateTokenFromEmail(String email, Integer id, String firstname, String lastname) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", email);
        claims.put("id", id);
        claims.put("firstname", firstname);
        claims.put("lastname", lastname);
        return Jwts.builder()
                .setSubject("subject")
                .addClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date((new Date()).getTime() + EXPIRATIONTIME))
                .signWith(key)
                .compact();
    }


}
