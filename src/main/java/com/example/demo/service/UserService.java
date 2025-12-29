// package com.example.demo.service;

// import com.example.demo.model.User;
// import org.springframework.security.core.Authentication;

// public interface UserService {
//     String registerUser(User user);
//     String loginUser(String username, String password);
// }

package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;

public interface UserService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(AuthRequest request);
}
