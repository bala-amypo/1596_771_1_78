package com.example.demo.model;

public class User {

    private Long userId;
    private String username;
    private String role;

    public User() {}

    public User(Long userId, String username, String role) {
        this.userId = userId;
        this.username = username;
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
}
