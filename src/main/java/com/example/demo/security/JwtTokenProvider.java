package com.example.demo.security;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenProvider {

    private final String secret;
    private final long validity;

    public JwtTokenProvider(String secret, long validity) {
        this.secret = secret;
        this.validity = validity;
    }

    // ✅ No Authentication used
    public String generateToken(String username, Long userId, String role) {
        String raw = username + "|" + userId + "|" + role + "|" + System.currentTimeMillis();
        return Base64.getEncoder().encodeToString(raw.getBytes());
    }

    public boolean validateToken(String token) {
        try {
            Base64.getDecoder().decode(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        String decoded = new String(Base64.getDecoder().decode(token));
        return decoded.split("\\|")[0];
    }

    public Map<String, Object> getAllClaims(String token) {
        String decoded = new String(Base64.getDecoder().decode(token));
        String[] parts = decoded.split("\\|");

        Map<String, Object> map = new HashMap<>();
        map.put("email", parts[0]);
        map.put("userId", Long.parseLong(parts[1]));
        map.put("role", parts[2]);

        return map;
    }
}
