package com.example.demo.controller;

import com.example.demo.security.CustomUserDetailsService;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final CustomUserDetailsService userService;
    private final JwtTokenProvider jwt;

    public AuthController(CustomUserDetailsService userService,
                          JwtTokenProvider jwt) {
        this.userService = userService;
        this.jwt = jwt;
    }

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody Map<String, String> req) {
        return userService.registerUser(
                req.get("name"),
                req.get("email"),
                req.get("password"),
                req.get("role")
        );
    }
}
