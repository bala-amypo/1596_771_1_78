package com.example.demo.model;

import java.time.LocalDateTime;

public class TaskRecord {
    private long id;
    private String taskCode;
    private String taskName;
    private String requiredSkill;
    private String requiredSkillLevel;
    private String priority;
    private String status;
    private LocalDateTime createdAt;
}
public TaskRecord(){

}
public TaskRecord(long id, String taskCode, String taskName, String requiredSkill, String requiredSkillLevel,
        String priority, String status, LocalDateTime createdAt) {
    this.id = id;
    this.taskCode = taskCode;
    this.taskName = taskName;
    this.requiredSkill = requiredSkill;
    this.requiredSkillLevel = requiredSkillLevel;
    this.priority = priority;
    this.status = status;
    this.createdAt = createdAt;
}
public String getTaskCode() {
    return taskCode;
}
public String getTaskName() {
    return taskName;
}
public String getRequiredSkill() {
    return requiredSkill;
}
public String getRequiredSkillLevel() {
    return requiredSkillLevel;
}
public String getPriority() {
    return priority;
}
public String getStatus() {
    return status;
}
public LocalDateTime getCreatedAt() {
    return createdAt;
}
public void setTaskCode(String taskCode) {
    this.taskCode = taskCode;
}
public void setTaskName(String taskName) {
    this.taskName = taskName;
}
public void setRequiredSkill(String requiredSkill) {
    this.requiredSkill = requiredSkill;
}
public void setRequiredSkillLevel(String requiredSkillLevel) {
    this.requiredSkillLevel = requiredSkillLevel;
}
public void setPriority(String priority) {
    this.priority = priority;
}
public void setStatus(String status) {
    this.status = status;
}
public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
}

