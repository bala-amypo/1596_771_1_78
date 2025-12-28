// package com.example.demo.security;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.security.Keys;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Component;
// import org.springframework.security.core.Authentication;

// import java.security.Key;
// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;

// @Component
// public class JwtTokenProvider {

//     private final Key key;
//     private final long validityInMs;

//     public JwtTokenProvider(
//             @Value("${jwt.secret}") String secret,
//             @Value("${jwt.expiration}") long validityInMs
//     ) {
//         this.key = Keys.hmacShaKeyFor(secret.getBytes());
//         this.validityInMs = validityInMs;
//     }

//     public String generateToken(Authentication auth, Long userId, String role) {
//         Map<String, Object> claims = new HashMap<>();
//         claims.put("userId", userId);
//         claims.put("role", role);
//         claims.put("email", auth.getName());

//         Date now = new Date();
//         Date expiry = new Date(now.getTime() + validityInMs);

//         return Jwts.builder()
//                 .setClaims(claims)
//                 .setSubject(auth.getName())
//                 .setIssuedAt(now)
//                 .setExpiration(expiry)
//                 .signWith(key)
//                 .compact();
//     }

//     public String getUsernameFromToken(String token) {
//         return getAllClaims(token).getSubject();
//     }

//     public boolean validateToken(String token) {
//         try {
//             getAllClaims(token);
//             return true;
//         } catch (Exception ex) {
//             return false;
//         }
//     }

//     public Claims getAllClaims(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(key)
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }

///new
package com.example.demo.security;

import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    private final String SECRET = "mysecretkey123456";
    private final long EXPIRATION = 86400000; // 1 day

    // ✅ Generate token
    public String generateToken(Authentication authentication, Long userId, String role) {
        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    // ✅ REQUIRED by JwtAuthenticationFilter
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    // ✅ REQUIRED by JwtAuthenticationFilter
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
