package com.example.demo.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class CustomUserDetailsService implements UserDetailsService {

    private final Map<String, Map<String, Object>> users = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    // Used by tests: registerUser(...)
    public Map<String, Object> registerUser(
            String fullName,
            String email,
            String password,
            String role
    ) {
        Map<String, Object> user = new HashMap<>();
        user.put("userId", idGenerator.getAndIncrement());
        user.put("fullName", fullName);
        user.put("email", email);
        user.put("password", password);
        user.put("role", role);

        users.put(email, user);
        return user;
    }

    // Used by tests: loadUserByUsername(...)
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        if (!users.containsKey(email)) {
            throw new UsernameNotFoundException("User not found");
        }

        Map<String, Object> user = users.get(email);

        return User.withUsername(email)
                .password((String) user.get("password"))
                .authorities("ROLE_" + user.get("role"))
                .build();
    }
}
