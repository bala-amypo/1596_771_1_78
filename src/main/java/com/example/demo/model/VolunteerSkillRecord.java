package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VolunteerSkillRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long volunteerId;
    private String skillName;
    private String skillLevel; // BEGINNER / INTERMEDIATE / EXPERT
    private Boolean certified;
    private LocalDateTime updatedAt;

    public VolunteerSkillRecord() {
        this.updatedAt = LocalDateTime.now();
    }

    public VolunteerSkillRecord(Long volunteerId, String skillName,
                                String skillLevel, Boolean certified) {
        this.volunteerId = volunteerId;
        this.skillName = skillName;
        this.skillLevel = skillLevel;
        this.certified = certified;
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Long getVolunteerId() { return volunteerId; }
    public String getSkillName() { return skillName; }
    public String getSkillLevel() { return skillLevel; }
}
