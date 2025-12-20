package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "task_records")
public class TaskRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String taskName;

    private String description;

    // ADD THIS FIELD
    private String status;

    public TaskRecord() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTaskName() { return taskName; }
    public void setTaskName(String taskName) { this.taskName = taskName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    // ADD THIS GETTER/SETTER
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
