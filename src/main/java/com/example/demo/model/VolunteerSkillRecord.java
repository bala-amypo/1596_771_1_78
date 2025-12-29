// // package com.example.demo.model;

// // import jakarta.persistence.*;
// // import java.time.LocalDateTime;

// // @Entity
// // @Table(name = "volunteer_skill_records")
// // public class VolunteerSkillRecord {

// //     @Id
// //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// //     private Long id;

// //     private Long volunteerId;

// //     private String skillName;

// //     private String skillLevel; // BEGINNER / INTERMEDIATE / EXPERT

// //     private boolean certified;

// //     private LocalDateTime updatedAt;

// //     @PrePersist
// //     @PreUpdate
// //     public void updateTimestamp() {
// //         this.updatedAt = LocalDateTime.now();
// //     }

// //     // Getters & Setters
// //     public Long getId() { return id; }
// //     public void setId(Long id) { this.id = id; }

// //     public Long getVolunteerId() { return volunteerId; }
// //     public void setVolunteerId(Long volunteerId) { this.volunteerId = volunteerId; }

// //     public String getSkillName() { return skillName; }
// //     public void setSkillName(String skillName) { this.skillName = skillName; }

// //     public String getSkillLevel() { return skillLevel; }
// //     public void setSkillLevel(String skillLevel) { this.skillLevel = skillLevel; }

// //     public boolean isCertified() { return certified; }
// //     public void setCertified(boolean certified) { this.certified = certified; }

// //     public LocalDateTime getUpdatedAt() { return updatedAt; }
// // }


// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "volunteer_skill_records")
// public class VolunteerSkillRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Long volunteerId;

//     private String skillName;

//     private String skillLevel; // BEGINNER / INTERMEDIATE / EXPERT

//     private boolean certified;

//     // ✅ DEFAULT VALUE (required for mocked tests)
//     private LocalDateTime updatedAt = LocalDateTime.now();

//     @PrePersist
//     @PreUpdate
//     public void updateTimestamp() {
//         if (this.updatedAt == null) {
//             this.updatedAt = LocalDateTime.now();
//         }
//     }

//     // -------- Getters & Setters --------

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public Long getVolunteerId() {
//         return volunteerId;
//     }

//     public void setVolunteerId(Long volunteerId) {
//         this.volunteerId = volunteerId;
//     }

//     public String getSkillName() {
//         return skillName;
//     }

//     public void setSkillName(String skillName) {
//         this.skillName = skillName;
//     }

//     public String getSkillLevel() {
//         return skillLevel;
//     }

//     public void setSkillLevel(String skillLevel) {
//         this.skillLevel = skillLevel;
//     }

//     public boolean isCertified() {
//         return certified;
//     }

//     public void setCertified(boolean certified) {
//         this.certified = certified;
//     }

//     public LocalDateTime getUpdatedAt() {
//         return updatedAt;
//     }

//     // optional but safe
//     public void setUpdatedAt(LocalDateTime updatedAt) {
//         this.updatedAt = updatedAt;
//     }
// }


//3
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "volunteer_skill_records")
public class VolunteerSkillRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skillName;

    private String proficiencyLevel; // e.g., Beginner, Intermediate, Expert

    private String description;

    // Optional: link to a volunteer profile
    @ManyToOne
    @JoinColumn(name = "volunteer_id")
    private VolunteerProfile volunteerProfile;

    // Constructors
    public VolunteerSkillRecord() {
    }

    public VolunteerSkillRecord(String skillName, String proficiencyLevel, String description) {
        this.skillName = skillName;
        this.proficiencyLevel = proficiencyLevel;
        this.description = description;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getProficiencyLevel() {
        return proficiencyLevel;
    }

    public void setProficiencyLevel(String proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VolunteerProfile getVolunteerProfile() {
        return volunteerProfile;
    }

    public void setVolunteerProfile(VolunteerProfile volunteerProfile) {
        this.volunteerProfile = volunteerProfile;
    }
}
