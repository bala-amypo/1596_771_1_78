package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;

import java.util.Date;
import java.util.Map;

public class JwtTokenProvider {

    private final String secretKey;
    private final long validityInMillis;

    // Used in tests
    public JwtTokenProvider(String secretKey, long validityInMillis) {
        this.secretKey = secretKey;
        this.validityInMillis = validityInMillis;
    }

    // Used in tests: generateToken(Authentication, userId, role)
    public String generateToken(Authentication authentication,
                                Long userId,
                                String role) {

        String email = authentication.getName();

        return Jwts.builder()
                .setSubject(email)
                .claim("email", email)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validityInMillis))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // Used in tests: validateToken(...)
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    // Used in tests: getUsernameFromToken(...)
    public String getUsernameFromToken(String token) {
        return getAllClaims(token).getSubject();
    }

    // Used in tests: getAllClaims(...)
    public Map<String, Object> getAllClaims(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        return claims;
    }
}
