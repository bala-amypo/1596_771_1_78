// // package com.example.demo.model;

// // import jakarta.persistence.*;
// // import java.time.LocalDateTime;

// // @Entity
// // @Table(
// //         name = "volunteer_profiles",
// //         uniqueConstraints = {
// //                 @UniqueConstraint(columnNames = "volunteerId"),
// //                 @UniqueConstraint(columnNames = "email"),
// //                 @UniqueConstraint(columnNames = "phone")
// //         }
// // )
// // public class VolunteerProfile {

// //     @Id
// //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// //     private Long id;

// //     @Column(nullable = false)
// //     private String volunteerId;

// //     @Column(nullable = false)
// //     private String fullName;

// //     @Column(nullable = false, unique = true)
// //     private String email;

// //     @Column(nullable = false, unique = true)
// //     private String phone;

// //     @Column(nullable = false)
// //     private String availabilityStatus; // AVAILABLE / BUSY / INACTIVE

// //     private LocalDateTime createdAt;

// //     @PrePersist
// //     public void prePersist() {
// //         this.createdAt = LocalDateTime.now();
// //         if (this.availabilityStatus == null) {
// //             this.availabilityStatus = "AVAILABLE";
// //         }
// //     }

// //     // Getters & Setters
// //     public Long getId() { return id; }
// //     public void setId(Long id) { this.id = id; }

// //     public String getVolunteerId() { return volunteerId; }
// //     public void setVolunteerId(String volunteerId) { this.volunteerId = volunteerId; }

// //     public String getFullName() { return fullName; }
// //     public void setFullName(String fullName) { this.fullName = fullName; }

// //     public String getEmail() { return email; }
// //     public void setEmail(String email) { this.email = email; }

// //     public String getPhone() { return phone; }
// //     public void setPhone(String phone) { this.phone = phone; }

// //     public String getAvailabilityStatus() { return availabilityStatus; }
// //     public void setAvailabilityStatus(String availabilityStatus) {
// //         this.availabilityStatus = availabilityStatus;
// //     }

// //     public LocalDateTime getCreatedAt() { return createdAt; }
// // }


// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity
// public class VolunteerProfile {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String volunteerId;
//     private String name;
//     private String availability;

//     // getters
//     public Long getId() {
//         return id;
//     }

//     public String getVolunteerId() {
//         return volunteerId;
//     }

//     public String getName() {
//         return name;
//     }

//     public String getAvailability() {
//         return availability;
//     }

//     // setters
//     public void setId(Long id) {
//         this.id = id;
//     }

//     public void setVolunteerId(String volunteerId) {
//         this.volunteerId = volunteerId;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     // ✅ THIS FIXES YOUR ERROR
//     public void setAvailability(String availability) {
//         this.availability = availability;
//     }
// }


package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class VolunteerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private boolean availability;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public VolunteerProfile() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public boolean isAvailability() { return availability; }
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
