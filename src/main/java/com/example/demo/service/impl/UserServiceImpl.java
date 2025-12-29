// package com.example.demo.service.impl;

// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.security.JwtTokenProvider;
// import com.example.demo.service.UserService;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// @Service
// public class UserServiceImpl implements UserService {

//     private final UserRepository userRepository;
//     private final PasswordEncoder passwordEncoder;
//     private final AuthenticationManager authenticationManager;
//     private final JwtTokenProvider jwtTokenProvider;

//     public UserServiceImpl(UserRepository userRepository, 
//                            PasswordEncoder passwordEncoder, 
//                            AuthenticationManager authenticationManager, 
//                            JwtTokenProvider jwtTokenProvider) {
//         this.userRepository = userRepository;
//         this.passwordEncoder = passwordEncoder;
//         this.authenticationManager = authenticationManager;
//         this.jwtTokenProvider = jwtTokenProvider;
//     }

//     @Override
//     public String registerUser(User user) {
//         // 1. Check if user already exists
//         if (userRepository.findByUsername(user.getUsername()).isPresent()) {
//             throw new RuntimeException("Username already taken");
//         }

//         // 2. Encode the password
//         user.setPassword(passwordEncoder.encode(user.getPassword()));

//         // 3. Save the user
//         userRepository.save(user);

//         return "User registered successfully!";
//     }

//     @Override
//     public String loginUser(String username, String password) {
//         // 1. Authenticate via Spring Security
//         Authentication authentication = authenticationManager.authenticate(
//                 new UsernamePasswordAuthenticationToken(username, password)
//         );

//         // 2. Fetch User details for the Token
//         User user = userRepository.findByUsername(username)
//                 .orElseThrow(() -> new RuntimeException("User not found"));

//         // 3. Generate and return JWT
//         return jwtTokenProvider.generateToken(
//                 authentication,
//                 user.getId(),
//                 user.getRole()
//         );
//     }
// }

package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public AuthResponse register(RegisterRequest request) {
        // Example logic: convert request to User entity and save
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword()); // ideally encode password
        userRepository.save(user);

        AuthResponse response = new AuthResponse();
        response.setMessage("User registered successfully");
        return response;
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        Optional<User> userOpt = userRepository.findByUsername(request.getUsername());
        if (userOpt.isPresent() && userOpt.get().getPassword().equals(request.getPassword())) {
            AuthResponse response = new AuthResponse();
            response.setMessage("Login successful");
            return response;
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
