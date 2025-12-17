package com.example.demo.model;

import java.time.LocalDateTime;

public class VolunteerProfile {
    private Long id;
    private String volunterrId;
    private String fullName;
    private String email;
    private String phone;
    private String AvailabilityStatus;
    private LocalDateTime createdAt;

public VolunteerProfile(){
    
}

public VolunteerProfile(Long id, String volunterrId, String fullName, String email, String phone,
        String availabilityStatus, LocalDateTime createdAt) {
    this.id = id;
    this.volunterrId = volunterrId;
    this.fullName = fullName;
    this.email = email;
    this.phone = phone;
    AvailabilityStatus = availabilityStatus;
    this.createdAt = createdAt;
}

public String getVolunterrId() {
    return volunterrId;
}

public String getFullName() {
    return fullName;
}

public String getEmail() {
    return email;
}

public String getPhone() {
    return phone;
}

public String getAvailabilityStatus() {
    return AvailabilityStatus;
}

public LocalDateTime getCreatedAt() {
    return createdAt;
}

public void setVolunterrId(String volunterrId) {
    this.volunterrId = volunterrId;
}

public void setFullName(String fullName) {
    this.fullName = fullName;
}

public void setEmail(String email) {
    this.email = email;
}

public void setPhone(String phone) {
    this.phone = phone;
}

public void setAvailabilityStatus(String availabilityStatus) {
    AvailabilityStatus = availabilityStatus;
}

public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
} 

}
