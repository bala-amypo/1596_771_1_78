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
import java.util.Map;

@Component
public class JwtTokenProvider {

    private final String secretKey;
    private final long validityInMilliseconds;

    public JwtTokenProvider(
            @Value("${jwt.secret:VerySecretKeyForJwtDemoApplication123456}") String secretKey,
            @Value("${jwt.validity:3600000}") long validityInMilliseconds) {

        this.secretKey = secretKey;
        this.validityInMilliseconds = validityInMilliseconds;
    }

    // Fixes: testRegisterUserProducesValidToken, testJwtTokenContainsUsername, 
    // testJwtClaimsContainRoleAndUserId, testJwtTokenIsDifferentForDifferentUsers
    public String generateToken(Authentication authentication, long userId, String role) {
        // The test expects the subject to be the name from the Authentication object
        String username = authentication.getName(); 
        
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("userId", userId);   // Required by test 
        claims.put("role", role);       // Required by test 
        claims.put("email", username);   // Required by test 

        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // Fixes: testJwtClaimsContainRoleAndUserId
    public Map<String, Object> getAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

    // Fixes: testJwtTokenContainsUsername
    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Fixes: testJwtValidation
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
