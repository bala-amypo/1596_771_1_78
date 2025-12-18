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
    private String status;
    private LocalDateTime assignedAt;

    // ✅ REQUIRED
    public TaskAssignmentRecord() {}

    public void setTaskId(Long taskId) { this.taskId = taskId; }
    public void setVolunteerId(Long volunteerId) { this.volunteerId = volunteerId; }
    public void setStatus(String status) { this.status = status; }
    public void setAssignedAt(LocalDateTime assignedAt) { this.assignedAt = assignedAt; }
}
