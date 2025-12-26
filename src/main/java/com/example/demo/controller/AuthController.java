package com.example.demo.controller;

import com.example.demo.security.CustomUserDetailsService;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody RegisterRequest request) {
        return userDetailsService.registerUser(
                request.getFullName(),
                request.getEmail(),
                encoder.encode(request.getPassword()),
                request.getRole()
        );
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {

        Authentication auth = new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword(),
                Collections.emptyList()
        );

        String token = jwtTokenProvider.generateToken(
                auth,
                1L,
                "USER"
        );

        return new AuthResponse(token);
    }
}
