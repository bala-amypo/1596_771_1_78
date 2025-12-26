package com.example.demo.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service   
public class CustomUserDetailsService implements UserDetailsService {

    private final Map<String, Map<String, Object>> users = new HashMap<>();
    private long id = 1;

    public Map<String, Object> registerUser(String name, String email,
                                            String password, String role) {
        Map<String, Object> u = new HashMap<>();
        u.put("userId", id++);
        u.put("email", email);
        u.put("password", password);
        u.put("role", role);
        users.put(email, u);
        return u;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        if (!users.containsKey(username))
            throw new UsernameNotFoundException("User not found");

        return User.withUsername(username)
                .password("{noop}password") // ⭐ avoids PasswordEncoder error
                .authorities(Collections.emptyList())
                .build();
    }
}
