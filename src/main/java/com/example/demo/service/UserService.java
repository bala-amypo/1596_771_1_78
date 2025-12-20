package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

    // Additional for AuthController
    User findByEmail(String email);
}
