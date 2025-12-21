package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VolunteerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String volunteerId;
    private String fullName;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    private String availabilityStatus; // AVAILABLE / BUSY / INACTIVE
    private LocalDateTime createdAt;

    public VolunteerProfile() {
        this.createdAt = LocalDateTime.now();
    }

    public VolunteerProfile(String volunteerId, String fullName,
                            String email, String phone,
                            String availabilityStatus) {
        this.volunteerId = volunteerId;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.availabilityStatus = availabilityStatus;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getVolunteerId() { return volunteerId; }
    public void setVolunteerId(String volunteerId) { this.volunteerId = volunteerId; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getAvailabilityStatus() { return availabilityStatus; }
    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
}
