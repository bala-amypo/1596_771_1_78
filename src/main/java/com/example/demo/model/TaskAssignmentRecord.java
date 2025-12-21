package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TaskAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long taskId;
    private Long volunteerId;
    private String status; // ACTIVE / COMPLETED / CANCELLED
    private String notes;
    private LocalDateTime assignedAt;

    public TaskAssignmentRecord() {
        this.status = "ACTIVE";
        this.assignedAt = LocalDateTime.now();
    }

    public TaskAssignmentRecord(Long taskId, Long volunteerId) {
        this.taskId = taskId;
        this.volunteerId = volunteerId;
        this.status = "ACTIVE";
        this.assignedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Long getTaskId() { return taskId; }
    public Long getVolunteerId() { return volunteerId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
