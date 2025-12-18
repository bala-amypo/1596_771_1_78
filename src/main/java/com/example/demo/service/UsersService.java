package com.example.demo.service;

import com.example.demo.model.Users;
import java.util.List;

public interface UsersService {

    Users save(Users user);
    List<Users> getAll();
    Users getById(Long id);
    void delete(Long id);
}
