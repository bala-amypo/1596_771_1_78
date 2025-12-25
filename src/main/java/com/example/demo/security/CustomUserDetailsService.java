package com.example.demo.security;

import java.util.HashMap;
import java.util.Map;

public class CustomUserDetailsService {

    private final Map<String, Map<String, Object>> users = new HashMap<>();
    private long idCounter = 1;

    public Map<String, Object> registerUser(
            String name,
            String email,
            String password,
            String role) {

        Map<String, Object> data = new HashMap<>();
        data.put("userId", idCounter++);
        data.put("email", email);
        data.put("password", password);
        data.put("role", role);
        data.put("name", name);

        users.put(email, data);
        return data;
    }

    public Object loadUserByUsername(String username) {
        if (!users.containsKey(username)) {
            throw new RuntimeException("User not found");
        }
        return users.get(username);
    }
}
