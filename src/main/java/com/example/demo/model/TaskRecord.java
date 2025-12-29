// // package com.example.demo.model;

// // import jakarta.persistence.*;
// // import java.time.LocalDateTime;

// // @Entity
// // @Table(
// //         name = "task_records",
// //         uniqueConstraints = @UniqueConstraint(columnNames = "taskCode")
// // )
// // public class TaskRecord {

// //     @Id
// //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// //     private Long id;

// //     @Column(nullable = false)
// //     private String taskCode;

// //     private String taskName;

// //     private String requiredSkill;

// //     private String requiredSkillLevel;

// //     private String priority; // LOW / MEDIUM / HIGH

// //     private String status; // OPEN / ASSIGNED / CLOSED

// //     private LocalDateTime createdAt;

// //     @PrePersist
// //     public void prePersist() {
// //         this.createdAt = LocalDateTime.now();
// //         if (this.status == null) {
// //             this.status = "OPEN";
// //         }
// //     }

// //     // Getters & Setters
// //     public Long getId() { return id; }
// //     public void setId(Long id) { this.id = id; }

// //     public String getTaskCode() { return taskCode; }
// //     public void setTaskCode(String taskCode) { this.taskCode = taskCode; }

// //     public String getTaskName() { return taskName; }
// //     public void setTaskName(String taskName) { this.taskName = taskName; }

// //     public String getRequiredSkill() { return requiredSkill; }
// //     public void setRequiredSkill(String requiredSkill) { this.requiredSkill = requiredSkill; }

// //     public String getRequiredSkillLevel() { return requiredSkillLevel; }
// //     public void setRequiredSkillLevel(String requiredSkillLevel) {
// //         this.requiredSkillLevel = requiredSkillLevel;
// //     }

// //     public String getPriority() { return priority; }
// //     public void setPriority(String priority) { this.priority = priority; }

// //     public String getStatus() { return status; }
// //     public void setStatus(String status) { this.status = status; }

// //     public LocalDateTime getCreatedAt() { return createdAt; }
// // }

// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.Data;
// import lombok.NoArgsConstructor;
// import lombok.AllArgsConstructor;

// @Entity
// @Table(name = "tasks")
// @Data                // FIX: Automatically generates getTitle() and getDescription()
// @NoArgsConstructor
// @AllArgsConstructor
// public class TaskRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String title;
    
//     private String description;

//     private String status;
// }

package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class TaskRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    private String requiredSkill;
    private int requiredSkillLevel;

    private String status;

    public TaskRecord() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequiredSkill() { return requiredSkill; }
    public void setRequiredSkill(String requiredSkill) {
        this.requiredSkill = requiredSkill;
    }

    public int getRequiredSkillLevel() { return requiredSkillLevel; }
    public void setRequiredSkillLevel(int requiredSkillLevel) {
        this.requiredSkillLevel = requiredSkillLevel;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
