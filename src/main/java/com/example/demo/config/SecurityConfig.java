// package com.example.demo.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {

//     @Bean
//         public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//                 http
//                             // ❌ CSRF disabled (Swagger + POST ku)
//                                         .csrf(csrf -> csrf.disable())

//                                                     .authorizeHttpRequests(auth -> auth

//                                                                     // ✅ OLD CODE – DO NOT CHANGE
//                                                                                     .requestMatchers("/hello", "/hello/**").permitAll()

//                                                                                                     // ✅ OLD CODE – Task APIs
//                                                                                                                     .requestMatchers("/tasks", "/tasks/**").permitAll()

//                                                                                                                                     // ✅ OLD CODE – Swagger
//                                                                                                                                                     .requestMatchers(
//                                                                                                                                                                             "/swagger-ui/**",
//                                                                                                                                                                                                     "/v3/api-docs/**",
//                                                                                                                                                                                                                             "/swagger-ui.html"
//                                                                                                                                                                                                                                             ).permitAll()

//                                                                                                                                                                                                                                                             // ✅ OLD CODE – Auth
//                                                                                                                                                                                                                                                                             .requestMatchers("/auth/**").permitAll()

//                                                                                                                                                                                                                                                                                             // 🔥 EXTRA CODE – ONLY ADDITION
//                                                                                                                                                                                                                                                                                                             .requestMatchers("/volunteers", "/volunteers/**").permitAll()
//                                                                                                                                                                                                                                                                                                                             .requestMatchers("/skills", "/skills/**").permitAll()
//                                                                                                                                                                                                                                                                                                                                             .requestMatchers("/assignments", "/assignments/**").permitAll()
//                                                                                                                                                                                                                                                                                                                                                             .requestMatchers("/evaluations", "/evaluations/**").permitAll()

//                                                                                                                                                                                                                                                                                                                                                                             // 🔒 Remaining secured
//                                                                                                                                                                                                                                                                                                                                                                                             .anyRequest().authenticated()
//                                                                                                                                                                                                                                                                                                                                                                                                         );

//                                                                                                                                                                                                                                                                                                                                                                                                                 return http.build();
//                                                                                                                                                                                                                                                                                                                                                                                                                     }

//                                                                                                                                                                                                                                                                                                                                                                                                                         // ✅ OLD CODE – AuthenticationManager
//                                                                                                                                                                                                                                                                                                                                                                                                                             @Bean
//                                                                                                                                                                                                                                                                                                                                                                                                                                 public AuthenticationManager authenticationManager(
//                                                                                                                                                                                                                                                                                                                                                                                                                                             AuthenticationConfiguration authenticationConfiguration) throws Exception {
//                                                                                                                                                                                                                                                                                                                                                                                                                                                     return authenticationConfiguration.getAuthenticationManager();
//                                                                                                                                                                                                                                                                                                                                                                                                                                                         }

//                                                                                                                                                                                                                                                                                                                                                                                                                                                             // ✅ OLD CODE – Password Encoder
//                                                                                                                                                                                                                                                                                                                                                                                                                                                                 @Bean
//                                                                                                                                                                                                                                                                                                                                                                                                                                                                     public PasswordEncoder passwordEncoder() {
//                                                                                                                                                                                                                                                                                                                                                                                                                                                                             return new BCryptPasswordEncoder();
//                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 }
//                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 }


package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // ✅ Disable CSRF (required for POST like register/login)
            .csrf(csrf -> csrf.disable())

            // ✅ Disable default login & basic auth
            .formLogin(form -> form.disable())
            .httpBasic(basic -> basic.disable())

            .authorizeHttpRequests(auth -> auth

                // ✅ OLD CODE – DO NOT CHANGE
                .requestMatchers("/hello", "/hello/**").permitAll()
                .requestMatchers("/tasks", "/tasks/**").permitAll()

                // ✅ Swagger
                .requestMatchers(
                        "/swagger-ui/**",
                        "/v3/api-docs/**",
                        "/swagger-ui.html"
                ).permitAll()

                // ✅ IMPORTANT FIX – Explicit POST permission
                .requestMatchers(HttpMethod.POST, "/auth/**").permitAll()
                .requestMatchers("/auth/**").permitAll()

                // ✅ Extra APIs
                .requestMatchers("/volunteers/**").permitAll()
                .requestMatchers("/skills/**").permitAll()
                .requestMatchers("/assignments/**").permitAll()
                .requestMatchers("/evaluations/**").permitAll()

                // 🔒 Remaining secured
                .anyRequest().authenticated()
            );

        return http.build();
    }

    // ✅ AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // ✅ Password Encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
