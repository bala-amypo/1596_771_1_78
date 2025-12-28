// package com.example.demo.controller;

// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.security.JwtTokenProvider;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final AuthenticationManager authenticationManager;
//     private final JwtTokenProvider jwtTokenProvider;
//     private final UserRepository userRepository;

//     public AuthController(AuthenticationManager authenticationManager,
//                           JwtTokenProvider jwtTokenProvider,
//                           UserRepository userRepository) {
//         this.authenticationManager = authenticationManager;
//         this.jwtTokenProvider = jwtTokenProvider;
//         this.userRepository = userRepository;
//     }

//     @PostMapping("/login")
//     public String login(@RequestParam String username,
//                         @RequestParam String password) {

//         Authentication authentication =
//                 authenticationManager.authenticate(
//                         new UsernamePasswordAuthenticationToken(
//                                 username, password));

//         User user = userRepository.findByUsername(username).orElseThrow();

//         return jwtTokenProvider.generateToken(
//                 authentication,
//                 user.getId(),
//                 user.getRole()
//         );
//     }
// }

///new
package com.example.demo.controller;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtTokenProvider jwtTokenProvider,
                          UserRepository userRepository,
                          PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {

        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            return "Username already exists";
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setRole("ROLE_USER"); // ✅ VERY IMPORTANT

        userRepository.save(user);

        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(username, password)
                );

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return jwtTokenProvider.generateToken(authentication, user.getId(), user.getRole());
    }
}
