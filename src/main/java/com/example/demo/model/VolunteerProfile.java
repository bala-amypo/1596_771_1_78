package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VolunteerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String volunteerId;

    private String fullName;
    private String email;
    private String phone;
    private String availabilityStatus;

    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        createdAt = LocalDateTime.now();
        availabilityStatus = "AVAILABLE";
    }

    public Long getId() { return id; }
    public String getVolunteerId() { return volunteerId; }
    public void setVolunteerId(String volunteerId) { this.volunteerId = volunteerId; }
    public String getAvailabilityStatus() { return availabilityStatus; }
    public void setAvailabilityStatus(String availabilityStatus) { this.availabilityStatus = availabilityStatus; }
}
