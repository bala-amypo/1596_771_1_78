// package com.example.demo.security;

// import org.springframework.security.core.userdetails.*;
// import org.springframework.stereotype.Service;

// import java.util.*;

// @Service   
// public class CustomUserDetailsService implements UserDetailsService {

//     private final Map<String, Map<String, Object>> users = new HashMap<>();
//     private long id = 1;

//     public Map<String, Object> registerUser(String name, String email,
//                                             String password, String role) {
//         Map<String, Object> u = new HashMap<>();
//         u.put("userId", id++);
//         u.put("email", email);
//         u.put("password", password);
//         u.put("role", role);
//         users.put(email, u);
//         return u;
//     }

//     @Override
//     public UserDetails loadUserByUsername(String username) {
//         if (!users.containsKey(username))
//             throw new UsernameNotFoundException("User not found");

//         return User.withUsername(username)
//                 .password("{noop}password") // ⭐ avoids PasswordEncoder error
//                 .authorities(Collections.emptyList())
//                 .build();
//     }
// }


package com.example.demo.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service   
public class CustomUserDetailsService implements UserDetailsService {

    // Internal storage to simulate a database for the test cases
    private final Map<String, Map<String, Object>> users = new HashMap<>();
    private long idCounter = 1;

    /**
     * Registers a user and returns a map containing user details.
     * Required for tests: testCustomUserDetailsServiceRegistersUser, testRegisterUserProducesValidToken
     */
    public Map<String, Object> registerUser(String name, String email,
                                            String password, String role) {
        Map<String, Object> user = new HashMap<>();
        user.put("userId", idCounter++);
        user.put("name", name);
        user.put("email", email);
        user.put("password", password);
        user.put("role", role);

        // Store by email as the key for lookup
        users.put(email, user);
        
        return user;
    }

    /**
     * Loads user by email.
     * Required for tests: testCustomUserDetailsServiceLoadsUser, testLoadUserThrowsForUnknownEmail
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Map<String, Object> user = users.get(username);
        
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        // Returns the user with stored credentials for Spring Security authentication
        return User.withUsername((String) user.get("email"))
                .password((String) user.get("password"))
                .authorities(Collections.emptyList()) // Authorities can be mapped from 'role' if needed
                .build();
    }
}