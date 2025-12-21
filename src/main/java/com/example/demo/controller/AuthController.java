package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {

        if (service.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        return service.saveUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User dbUser = service.findByEmail(user.getEmail());

        if (!dbUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return "Login successful";
        // JWT token returned here in real implementation
    }
}
