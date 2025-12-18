package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class VolunteerSkillRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long volunteerId;
    private String skillName;
    private String level;

    // ✅ REQUIRED by JPA
    public VolunteerSkillRecord() {}

    // getters & setters
    public Long getId() { return id; }

    public Long getVolunteerId() { return volunteerId; }
    public void setVolunteerId(Long volunteerId) { this.volunteerId = volunteerId; }

    public String getSkillName() { return skillName; }
    public void setSkillName(String skillName) { this.skillName = skillName; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
}
