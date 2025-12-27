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
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//         http
//             // ❌ CSRF disabled (Swagger + POST ku)
//             .csrf(csrf -> csrf.disable())

//             .authorizeHttpRequests(auth -> auth

//                 // ✅ OLD CODE – DO NOT CHANGE
//                 .requestMatchers("/hello", "/hello/**").permitAll()

//                 // ✅ OLD CODE – Task APIs
//                 .requestMatchers("/tasks", "/tasks/**").permitAll()

//                 // ✅ OLD CODE – Swagger
//                 .requestMatchers(
//                         "/swagger-ui/**",
//                         "/v3/api-docs/**",
//                         "/swagger-ui.html"
//                 ).permitAll()

//                 // ✅ OLD CODE – Auth
//                 .requestMatchers("/auth/**").permitAll()

//                 // 🔥 EXTRA CODE – ONLY ADDITION
//                 .requestMatchers("/volunteers", "/volunteers/**").permitAll()
//                 .requestMatchers("/skills", "/skills/**").permitAll()
//                 .requestMatchers("/assignments", "/assignments/**").permitAll()
//                 .requestMatchers("/evaluations", "/evaluations/**").permitAll()

//                 // 🔒 Remaining secured
//                 .anyRequest().authenticated()
//             );

//         return http.build();
//     }

//     // ✅ OLD CODE – AuthenticationManager
//     @Bean
//     public AuthenticationManager authenticationManager(
//             AuthenticationConfiguration authenticationConfiguration) throws Exception {
//         return authenticationConfiguration.getAuthenticationManager();
//     }

//     // ✅ OLD CODE – Password Encoder
//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }


package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // 1. Enable CORS using the bean defined below
            .cors(Customizer.withDefaults())
            
            // 2. Disable CSRF (Solves 403 for POST/PUT requests)
            .csrf(csrf -> csrf.disable())

            // 3. Set session to stateless (Standard for JWT)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/hello", "/hello/**").permitAll()
                .requestMatchers("/tasks", "/tasks/**").permitAll()
                .requestMatchers(
                        "/swagger-ui/**",
                        "/v3/api-docs/**",
                        "/swagger-ui.html"
                ).permitAll()
                .requestMatchers("/auth/**").permitAll()
                .requestMatchers("/volunteers/**", "/skills/**", "/assignments/**", "/evaluations/**").permitAll()
                .anyRequest().authenticated()
            );

        return http.build();
    }

    // 4. CORS Configuration Bean (Solves "Failed to fetch")
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // Allow Swagger UI and Localhost origins
        configuration.setAllowedOriginPatterns(List.of("*")); 
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "Cache-Control"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
