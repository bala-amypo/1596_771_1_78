package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "task_assignment_record")
public class TaskAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String taskName;

    @Column(nullable = false)
    private String assignedTo;

    public TaskAssignmentRecord() {}

    public TaskAssignmentRecord(String taskName, String assignedTo) {
        this.taskName = taskName;
        this.assignedTo = assignedTo;
    }

    public Long getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
}
