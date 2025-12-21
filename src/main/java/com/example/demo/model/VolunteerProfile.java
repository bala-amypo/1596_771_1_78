package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "volunteer_profiles")
public class VolunteerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String role; // VOLUNTEER / COORDINATOR

    private String availabilityStatus; // AVAILABLE / BUSY / UNAVAILABLE

    private LocalDateTime createdAt = LocalDateTime.now();

    // getters and setters
}
