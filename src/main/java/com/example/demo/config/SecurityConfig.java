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


//  //swagger
// package com.example.demo.config;

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
//             .csrf(csrf -> csrf.disable())
//             .formLogin(form -> form.disable())
//             .httpBasic(basic -> basic.disable())

//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers(
//                         "/auth/**",
//                         "/swagger-ui/**",
//                         "/v3/api-docs/**"
//                 ).permitAll()
//                 .anyRequest().authenticated()
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

package com.example.demo.config;

import com.example.demo.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .sessionManagement(session ->
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .formLogin(form -> form.disable())
            .httpBasic(basic -> basic.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/auth/**",
                    "/v3/api-docs/**",
                    "/swagger-ui/**",
                    "/swagger-ui.html"
                ).permitAll()
                .anyRequest().authenticated()
            )
            .addFilterBefore(
                jwtAuthenticationFilter,
                UsernamePasswordAuthenticationFilter.class
            );

        return http.build();
    }

    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOriginPatterns(List.of("*"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
