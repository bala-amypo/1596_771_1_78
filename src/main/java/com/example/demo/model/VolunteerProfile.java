// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(
//         name = "volunteer_profiles",
//         uniqueConstraints = {
//                 @UniqueConstraint(columnNames = "volunteerId"),
//                 @UniqueConstraint(columnNames = "email"),
//                 @UniqueConstraint(columnNames = "phone")
//         }
// )
// public class VolunteerProfile {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private String volunteerId;

//     @Column(nullable = false)
//     private String fullName;

//     @Column(nullable = false, unique = true)
//     private String email;

//     @Column(nullable = false, unique = true)
//     private String phone;

//     @Column(nullable = false)
//     private String availabilityStatus; // AVAILABLE / BUSY / INACTIVE

//     private LocalDateTime createdAt;

//     @PrePersist
//     public void prePersist() {
//         this.createdAt = LocalDateTime.now();
//         if (this.availabilityStatus == null) {
//             this.availabilityStatus = "AVAILABLE";
//         }
//     }

//     // Getters & Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getVolunteerId() { return volunteerId; }
//     public void setVolunteerId(String volunteerId) { this.volunteerId = volunteerId; }

//     public String getFullName() { return fullName; }
//     public void setFullName(String fullName) { this.fullName = fullName; }

//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }

//     public String getPhone() { return phone; }
//     public void setPhone(String phone) { this.phone = phone; }

//     public String getAvailabilityStatus() { return availabilityStatus; }
//     public void setAvailabilityStatus(String availabilityStatus) {
//         this.availabilityStatus = availabilityStatus;
//     }

//     public LocalDateTime getCreatedAt() { return createdAt; }
// }


package com.example.demo.model;
import jakarta.persistence.*;
@Entity
@Table(name = "volunteer_profiles")
public class VolunteerProfile {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(unique = true)
private String volunteerId;
private String fullName;
@Column(unique = true)
private String email;
@Column(unique = true)
private String phone;
private String availabilityStatus;
public VolunteerProfile() {}
public VolunteerProfile(String name, String email, String availabilityStatus) {
this.fullName = name;
this.email = email;
this.availabilityStatus = availabilityStatus;
}
public Long getId() { return id; }
public void setId(Long id) { this.id = id; }
public String getVolunteerId() { return volunteerId; }
public void setVolunteerId(String volunteerId) { this.volunteerId = volunteerId; }
public String getFullName() { return fullName; }
public void setFullName(String fullName) { this.fullName = fullName; }
public String getName() { return fullName; }
public void setName(String name) { this.fullName = name; }
public String getEmail() { return email; }
public void setEmail(String email) { this.email = email; }
public String getPhone() { return phone; }
public void setPhone(String phone) { this.phone = phone; }
public String getAvailabilityStatus() { return availabilityStatus; }
public void setAvailabilityStatus(String availabilityStatus) { this.availabilityStatus =
availabilityStatus; }
}
