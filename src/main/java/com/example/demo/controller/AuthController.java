package com.example.demo.controller;

import com.example.demo.security.CustomUserDetailsService;
import com.example.demo.security.JwtTokenProvider;
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
    public Map<String, Object> register(@RequestBody Map<String, String> request) {
        return userDetailsService.registerUser(
                request.get("fullName"),
                request.get("email"),
                encoder.encode(request.get("password")),
                request.get("role")
        );
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {

        Authentication auth = new UsernamePasswordAuthenticationToken(
                request.get("email"),
                request.get("password"),
                Collections.emptyList()
        );

        String token = jwtTokenProvider.generateToken(auth, 1L, "USER");
        return Collections.singletonMap("token", token);
    }
}
