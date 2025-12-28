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


//swagger
// package com.example.demo.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// @Configuration
// public class SecurityConfig {

//     private final JwtAuthenticationFilter jwtAuthenticationFilter;

//     public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
//         this.jwtAuthenticationFilter = jwtAuthenticationFilter;
//     }

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//         http
//             // 🔥 MUST BE FIRST
//             .csrf(csrf -> csrf.disable())
//             .formLogin(form -> form.disable())
//             .httpBasic(basic -> basic.disable())

//             .authorizeHttpRequests(auth -> auth
//                 // 🔥 MUST BE FIRST
//                 .requestMatchers("/auth/**").permitAll()
//                 .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
//                 .anyRequest().authenticated()
//             )

//             // 🔥 MUST BE BEFORE UsernamePasswordAuthenticationFilter
//             .addFilterBefore(
//                     jwtAuthenticationFilter,
//                     UsernamePasswordAuthenticationFilter.class
//             );

//         return http.build();
//     }

//     @Bean
//     public AuthenticationManager authenticationManager(
//             AuthenticationConfiguration config) throws Exception {
//         return config.getAuthenticationManager();
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }
package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // 🔥 Disable CSRF (JWT based API)
            .csrf(csrf -> csrf.disable())

            // 🔥 Enable CORS
            .cors(cors -> {})

            // 🔥 Stateless session (JWT only)
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            // 🔥 Disable default auth mechanisms
            .formLogin(form -> form.disable())
            .httpBasic(basic -> basic.disable())

            // 🔥 Authorization rules
            .authorizeHttpRequests(auth -> auth
                // 🔥 VERY IMPORTANT — allow preflight requests
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                // 🔥 Auth endpoints
                .requestMatchers("/auth/**").permitAll()

                // 🔥 Swagger
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()

                // 🔒 Everything else needs JWT
                .anyRequest().authenticated()
            )

            // 🔥 JWT filter
            .addFilterBefore(
                jwtAuthenticationFilter,
                UsernamePasswordAuthenticationFilter.class
            );

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 🔥 CORS CONFIGURATION (THIS FIXES 403)
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowedOrigins(List.of("*"));
        config.setAllowedMethods(
                List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")
        );
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(false);

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }
}
