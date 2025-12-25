package com.example.demo.security;

import org.springframework.security.core.userdetails.*;
import java.util.*;

public class CustomUserDetailsService implements UserDetailsService {

    private final Map<String, Map<String, Object>> users = new HashMap<>();
    private long idCounter = 1;

    public Map<String, Object> registerUser(
            String name,
            String email,
            String password,
            String role) {

        Map<String, Object> map = new HashMap<>();
        map.put("userId", idCounter++);
        map.put("email", email);
        map.put("password", password);
        map.put("role", role);
        map.put("name", name);

        users.put(email, map);
        return map;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        if (!users.containsKey(username))
            throw new UsernameNotFoundException("User not found");

        Map<String, Object> u = users.get(username);
        return User.withUsername(username)
                .password((String) u.get("password"))
                .authorities(new ArrayList<>())
                .build();
    }
}
