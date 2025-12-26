// // package com.example.demo.security;

// // import io.jsonwebtoken.Claims;
// // import io.jsonwebtoken.Jwts;
// // import io.jsonwebtoken.SignatureAlgorithm;
// // import org.springframework.security.core.Authentication;
// // import org.springframework.stereotype.Component;

// // import java.util.Date;

// // @Component
// // public class JwtTokenProvider {

// //     private String secretKey;
// //     private long validityInMilliseconds;

// //     public JwtTokenProvider(String secretKey, long validityInMilliseconds) {
// //         this.secretKey = secretKey;
// //         this.validityInMilliseconds = validityInMilliseconds;
// //     }

// //     public String generateToken(Authentication authentication,
// //                                 long userId,
// //                                 String username) {

// //         Claims claims = Jwts.claims().setSubject(username);
// //         claims.put("userId", userId);

// //         Date now = new Date();
// //         Date expiry = new Date(now.getTime() + validityInMilliseconds);

// //         return Jwts.builder()
// //                 .setClaims(claims)
// //                 .setIssuedAt(now)
// //                 .setExpiration(expiry)
// //                 .signWith(SignatureAlgorithm.HS256, secretKey)
// //                 .compact();
// //     }

// //     public Claims getAllClaims(String token) {
// //         return Jwts.parser()
// //                 .setSigningKey(secretKey)
// //                 .parseClaimsJws(token)
// //                 .getBody();
// //     }

// //     // ✅ THIS WAS MISSING
// //     public String getUsernameFromToken(String token) {
// //         Claims claims = getAllClaims(token);
// //         return claims.getSubject();
// //     }

// //     public boolean validateToken(String token) {
// //         try {
// //             Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
// //             return true;
// //         } catch (Exception e) {
// //             return false;
// //         }
// //     }
// // }
// package com.example.demo.security;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.security.core.Authentication;
// import org.springframework.stereotype.Component;

// import java.util.Date;

// @Component
// public class JwtTokenProvider {

//     private final String secretKey;
//     private final long validityInMilliseconds;

//     public JwtTokenProvider(
//             @Value("${jwt.secret:exam-secret-key}") String secretKey,
//             @Value("${jwt.validity:3600000}") long validityInMilliseconds) {

//         this.secretKey = secretKey;
//         this.validityInMilliseconds = validityInMilliseconds;
//     }

//     public String generateToken(Authentication authentication,
//                                 long userId,
//                                 String username) {

//         Claims claims = Jwts.claims().setSubject(username);
//         claims.put("userId", userId);

//         Date now = new Date();
//         Date expiry = new Date(now.getTime() + validityInMilliseconds);

//         return Jwts.builder()
//                 .setClaims(claims)
//                 .setIssuedAt(now)
//                 .setExpiration(expiry)
//                 .signWith(SignatureAlgorithm.HS256, secretKey)
//                 .compact();
//     }

//     public Claims getAllClaims(String token) {
//         return Jwts.parser()
//                 .setSigningKey(secretKey)
//                 .parseClaimsJws(token)
//                 .getBody();
//     }

//     public String getUsernameFromToken(String token) {
//         return getAllClaims(token).getSubject();
//     }

//     public boolean validateToken(String token) {
//         try {
//             Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }
// }

package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenProvider {

    private String secretKey;
    private long validityInMilliseconds;

    // The test calls this constructor directly
    public JwtTokenProvider(
            @Value("${jwt.secret:VerySecretKeyForJwtDemoApplication123456}") String secretKey,
            @Value("${jwt.validity:3600000}") long validityInMilliseconds) {
        this.secretKey = secretKey;
        this.validityInMilliseconds = validityInMilliseconds;
    }

    // Must match: generateToken(Authentication, long, String)
    public String generateToken(Authentication authentication, long userId, String role) {
        // The test expects the username to be retrieved from authentication.getName()
        String username = authentication.getName();
        
        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMilliseconds);

        // Build claims - Test expects "userId", "role", and "email"
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        claims.put("role", role);
        claims.put("email", username);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // Required for: testJwtClaimsContainRoleAndUserId
    public Map<String, Object> getAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

    // Required for: testJwtTokenContainsUsername
    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Required for: testJwtValidation
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
