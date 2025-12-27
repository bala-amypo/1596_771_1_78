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


package com.example.demo.security;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Component
public class JwtTokenProvider {
private final String secretKey;
private final long expirationTime;
private final Key key;
public JwtTokenProvider() {
this.secretKey = "VerySecretKeyForJwtDemoApplication123456";
this.expirationTime = 3600000L;
this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
}
public JwtTokenProvider(String secretKey, long expirationTime) {
this.secretKey = secretKey;
this.expirationTime = expirationTime;
this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
}
public String generateToken(String username, String role) {
Date now = new Date();
Date expiry = new Date(now.getTime() + expirationTime);
return Jwts.builder()
.setSubject(username
.claim("role", role)
.setIssuedAt(now)
.setExpiration(expiry)
.signWith(key)
.compact();
}
public String generateToken(Authentication auth, Long userId, String role) {
Date now = new Date();
Date expiry = new Date(now.getTime() + expirationTime);
return Jwts.builder()
.setSubject(auth.getName())
.claim("userId", userId)
.claim("role", role)
.claim("email", auth.getName())
.setIssuedAt(now)
.setExpiration(expiry)
.signWith(key)
.compact();
}
public boolean validateToken(String token) {
try {
Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
return true;
} catch (JwtException | IllegalArgumentException e) {
return false;
}
}
public String getUsernameFromToken(String token) {
Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
return claims.getSubject();
}
public Map<String, Object> getAllClaims(String token) {
Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
Map<String, Object> result = new HashMap<>();
result.put("userId", claims.get("userId"));
result.put("role", claims.get("role"));
result.put("email", claims.get("email"));
return result;
}
}