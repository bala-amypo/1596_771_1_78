package com.example.demo.model;

public class VolunteerSkillRecord {

    private Long id;
    private Long volunteerId;
    private String skillName;
    private String level;

    public VolunteerSkillRecord() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getVolunteerId() { return volunteerId; }
    public void setVolunteerId(Long volunteerId) { this.volunteerId = volunteerId; }

    public String getSkillName() { return skillName; }
    public void setSkillName(String skillName) { this.skillName = skillName; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
}
