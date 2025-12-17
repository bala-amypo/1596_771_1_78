package com.example.demo.model;

import java.time.LocalDateTime;

public class VolunteerSkillRecord{
    private Long id;
    private Long volunteerId;
    private String skillName;
    private String skillLevel;
    private Boolean certified;
    private LocalDateTime updatedAt;

public VolunteerSkillRecord(){

}
public VolunteerSkillRecord(Long id, Long volunteerId, String skillName, String skillLevel, Boolean certified,
            LocalDateTime updatedAt) {
        this.id = id;
        this.volunteerId = volunteerId;
        this.skillName = skillName;
        this.skillLevel = skillLevel;
        this.certified = certified;
        this.updatedAt = updatedAt;
    }
public Long getVolunteerId() {
    return volunteerId;
}
public String getSkillName() {
    return skillName;
}
public String getSkillLevel() {
    return skillLevel;
}
public Boolean getCertified() {
    return certified;
}
public LocalDateTime getUpdatedAt() {
    return updatedAt;
}
public void setVolunteerId(Long volunteerId) {
    this.volunteerId = volunteerId;
}
public void setSkillName(String skillName) {
    this.skillName = skillName;
}
public void setSkillLevel(String skillLevel) {
    this.skillLevel = skillLevel;
}
public void setCertified(Boolean certified) {
    this.certified = certified;
}
public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
}

}
