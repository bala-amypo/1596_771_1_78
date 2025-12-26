// package com.example.demo.model;

// public class TaskRecord {
//     private Long id;
//     private String taskCode;
//     private String taskName;
//     private String requiredSkill;
//     private String requiredSkillLevel;
//     private String priority;
//     private String status = "OPEN";

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getTaskCode() { return taskCode; }
//     public void setTaskCode(String taskCode) { this.taskCode = taskCode; }

//     public String getTaskName() { return taskName; }
//     public void setTaskName(String taskName) { this.taskName = taskName; }

//     public String getRequiredSkill() { return requiredSkill; }
//     public void setRequiredSkill(String requiredSkill) { this.requiredSkill = requiredSkill; }

//     public String getRequiredSkillLevel() { return requiredSkillLevel; }
//     public void setRequiredSkillLevel(String requiredSkillLevel) {
//         this.requiredSkillLevel = requiredSkillLevel;
//     }

//     public String getPriority() { return priority; }
//     public void setPriority(String priority) { this.priority = priority; }

//     public String getStatus() { return status; }
//     public void setStatus(String status) { this.status = status; }
// }
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "task_record")
public class TaskRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String taskCode;
    private String taskName;
    private String priority;
    private String requiredSkill;
    private String requiredSkillLevel;
    private String status;

    public TaskRecord() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getTaskName() {   // ✅ REQUIRED
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getPriority() {   // ✅ REQUIRED
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getRequiredSkill() {
        return requiredSkill;
    }

    public void setRequiredSkill(String requiredSkill) {
        this.requiredSkill = requiredSkill;
    }

    public String getRequiredSkillLevel() {
        return requiredSkillLevel;
    }

    public void setRequiredSkillLevel(String requiredSkillLevel) {
        this.requiredSkillLevel = requiredSkillLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
