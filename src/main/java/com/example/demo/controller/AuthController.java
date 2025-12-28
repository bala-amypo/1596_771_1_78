// // package com.example.demo.controller;

// // import com.example.demo.model.User;
// // import com.example.demo.repository.UserRepository;
// // import com.example.demo.security.JwtTokenProvider;
// // import org.springframework.security.authentication.AuthenticationManager;
// // import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// // import org.springframework.security.core.Authentication;
// // import org.springframework.web.bind.annotation.*;

// // @RestController
// // @RequestMapping("/auth")
// // public class AuthController {

// //     private final AuthenticationManager authenticationManager;
// //     private final JwtTokenProvider jwtTokenProvider;
// //     private final UserRepository userRepository;

// //     public AuthController(AuthenticationManager authenticationManager,
// //                           JwtTokenProvider jwtTokenProvider,
// //                           UserRepository userRepository) {
// //         this.authenticationManager = authenticationManager;
// //         this.jwtTokenProvider = jwtTokenProvider;
// //         this.userRepository = userRepository;
// //     }

// //     @PostMapping("/login")
// //     public String login(@RequestParam String username,
// //                         @RequestParam String password) {

// //         Authentication authentication =
// //                 authenticationManager.authenticate(
// //                         new UsernamePasswordAuthenticationToken(
// //                                 username, password));

// //         User user = userRepository.findByUsername(username).orElseThrow();

// //         return jwtTokenProvider.generateToken(
// //                 authentication,
// //                 user.getId(),
// //                 user.getRole()
// //         );
// //     }
// // }

// package com.example.demo.controller;

// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.security.JwtTokenProvider;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.crypto.password.PasswordEncoder; // Added
// import org.springframework.web.bind.annotation.*;

// import java.util.Map;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final AuthenticationManager authenticationManager;
//     private final JwtTokenProvider jwtTokenProvider;
//     private final UserRepository userRepository;
//     private final PasswordEncoder passwordEncoder; // Added

//     public AuthController(AuthenticationManager authenticationManager,
//                           JwtTokenProvider jwtTokenProvider,
//                           UserRepository userRepository,
//                           PasswordEncoder passwordEncoder) {
//         this.authenticationManager = authenticationManager;
//         this.jwtTokenProvider = jwtTokenProvider;
//         this.userRepository = userRepository;
//         this.passwordEncoder = passwordEncoder;
//     }

//     @PostMapping("/register")
//     public String register(@RequestBody User user) {
//         // 1. Check if user already exists
//         if (userRepository.findByUsername(user.getUsername()).isPresent()) {
//             throw new RuntimeException("Username already taken");
//         }

//         // 2. Encode the password before saving
//         user.setPassword(passwordEncoder.encode(user.getPassword()));
        
//         // 3. Save the user
//         userRepository.save(user);

//         return "User registered successfully!";
//     }

//     @PostMapping("/login")
//     public String login(@RequestParam String username,
//                         @RequestParam String password) {

//         Authentication authentication =
//                 authenticationManager.authenticate(
//                         new UsernamePasswordAuthenticationToken(
//                                 username, password));

//         User user = userRepository.findByUsername(username)
//                 .orElseThrow(() -> new RuntimeException("User not found"));

//         return jwtTokenProvider.generateToken(
//                 authentication,
//                 user.getId(),
//                 user.getRole()
//         );
//     }
// }

package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository,
                          PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return "Username already exists";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User dbUser = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(user.getPassword(), dbUser.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return "Login successful";
    }
}
