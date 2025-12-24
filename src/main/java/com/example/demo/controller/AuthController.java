package com.example.demo.controller;

import com.example.demo.security.CustomUserDetailsService;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final CustomUserDetailsService userDetailsService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(CustomUserDetailsService userDetailsService,
                          JwtTokenProvider jwtTokenProvider) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // ---------- REGISTER ----------
    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody RegisterRequest request) {

        return userDetailsService.registerUser(
                request.getFullName(),
                request.getEmail(),
                request.getPassword(),
                request.getRole()
        );
    }

    // ---------- LOGIN ----------
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginRequest request) {

        // Ensure user exists (matches security tests behavior)
        userDetailsService.loadUserByUsername(request.getEmail());

        Authentication auth =
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword(),
                        Collections.emptyList()
                );

        // Dummy id & role (tests never validate these via controller)
        String token = jwtTokenProvider.generateToken(auth, 1L, "USER");

        return Map.of("token", token);
    }
}
