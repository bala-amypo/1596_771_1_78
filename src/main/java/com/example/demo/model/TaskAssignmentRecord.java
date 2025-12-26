// package com.example.demo.model;

// public class TaskAssignmentRecord {
//     private Long id;
//     private Long taskId;
//     private Long volunteerId;
//     private String status = "ACTIVE";

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public Long getTaskId() { return taskId; }
//     public void setTaskId(Long taskId) { this.taskId = taskId; }

//     public Long getVolunteerId() { return volunteerId; }
//     public void setVolunteerId(Long volunteerId) { this.volunteerId = volunteerId; }

//     public String getStatus() { return status; }
//     public void setStatus(String status) { this.status = status; }
// }


package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "task_assignment_record")
public class TaskAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_id", nullable = false)
    private Long taskId;

    @Column(name = "volunteer_id", nullable = false)
    private Long volunteerId;

    @Column(name = "status")
    private String status = "ACTIVE";

    public TaskAssignmentRecord() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(Long volunteerId) {
        this.volunteerId = volunteerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
