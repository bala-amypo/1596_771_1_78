// // // package com.example.demo.model;

// // // import jakarta.persistence.*;
// // // import java.time.LocalDateTime;

// // // @Entity
// // // @Table(name = "task_assignment_records")
// // // public class TaskAssignmentRecord {

// // //     @Id
// // //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// // //     private Long id;

// // //     private Long taskId;

// // //     private Long volunteerId;

// // //     private LocalDateTime assignedAt;

// // //     private String status; // ACTIVE / COMPLETED / CANCELLED

// // //     @PrePersist
// // //     public void prePersist() {
// // //         this.assignedAt = LocalDateTime.now();
// // //         if (this.status == null) {
// // //             this.status = "ACTIVE";
// // //         }
// // //     }

// // //     // Getters & Setters
// // //     public Long getId() { return id; }
// // //     public void setId(Long id) { this.id = id; }

// // //     public Long getTaskId() { return taskId; }
// // //     public void setTaskId(Long taskId) { this.taskId = taskId; }

// // //     public Long getVolunteerId() { return volunteerId; }
// // //     public void setVolunteerId(Long volunteerId) { this.volunteerId = volunteerId; }

// // //     public LocalDateTime getAssignedAt() { return assignedAt; }

// // //     public String getStatus() { return status; }
// // //     public void setStatus(String status) { this.status = status; }
// // // }

// // package com.example.demo.model;

// // import jakarta.persistence.*;
// // import java.time.LocalDateTime;

// // @Entity
// // @Table(name = "task_assignment_records")
// // public class TaskAssignmentRecord {

// //     @Id
// //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// //     private Long id;

// //     private Long taskId;

// //     private Long volunteerId;

// //     private LocalDateTime assignedAt;

// //     private String status; // ACTIVE / COMPLETED / CANCELLED

// //     @PrePersist
// //     public void onCreate() {
// //         if (this.assignedAt == null) {
// //             this.assignedAt = LocalDateTime.now();
// //         }
// //         if (this.status == null) {
// //             this.status = "ACTIVE";
// //         }
// //     }

// //     @PreUpdate
// //     public void onUpdate() {
// //         // optional but keeps timestamp fresh if tests expect update
// //         this.assignedAt = LocalDateTime.now();
// //     }

// //     // ---------------- GETTERS & SETTERS ----------------

// //     public Long getId() {
// //         return id;
// //     }

// //     public void setId(Long id) {
// //         this.id = id;
// //     }

// //     public Long getTaskId() {
// //         return taskId;
// //     }

// //     public void setTaskId(Long taskId) {
// //         this.taskId = taskId;
// //     }

// //     public Long getVolunteerId() {
// //         return volunteerId;
// //     }

// //     public void setVolunteerId(Long volunteerId) {
// //         this.volunteerId = volunteerId;
// //     }

// //     public LocalDateTime getAssignedAt() {
// //         return assignedAt;
// //     }

// //     public void setAssignedAt(LocalDateTime assignedAt) {
// //         this.assignedAt = assignedAt;
// //     }

// //     public String getStatus() {
// //         return status;
// //     }

// //     public void setStatus(String status) {
// //         this.status = status;
// //     }
// // }


// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "task_assignment_records")
// public class TaskAssignmentRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Long taskId;

//     private Long volunteerId;

//     // ✅ default timestamp (mock-safe)
//     private LocalDateTime assignedAt = LocalDateTime.now();

//     // ✅ default status (mock-safe)
//     private String status = "ACTIVE"; // ACTIVE / COMPLETED / CANCELLED

//     @PrePersist
//     public void onCreate() {
//         if (this.assignedAt == null) {
//             this.assignedAt = LocalDateTime.now();
//         }
//         if (this.status == null) {
//             this.status = "ACTIVE";
//         }
//     }

//     @PreUpdate
//     public void onUpdate() {
//         this.assignedAt = LocalDateTime.now();
//     }

//     // ---------------- GETTERS & SETTERS ----------------

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public Long getTaskId() {
//         return taskId;
//     }

//     public void setTaskId(Long taskId) {
//         this.taskId = taskId;
//     }

//     public Long getVolunteerId() {
//         return volunteerId;
//     }

//     public void setVolunteerId(Long volunteerId) {
//         this.volunteerId = volunteerId;
//     }

//     public LocalDateTime getAssignedAt() {
//         return assignedAt;
//     }

//     public void setAssignedAt(LocalDateTime assignedAt) {
//         this.assignedAt = assignedAt;
//     }

//     public String getStatus() {
//         return status;
//     }

//     public void setStatus(String status) {
//         this.status = status;
//     }
// }

package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class TaskAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "volunteer_profile_id", nullable = false)
    private VolunteerProfile volunteerProfile;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @Column(nullable = false)
    private String status; // ACTIVE, COMPLETED, CANCELLED

    // Constructors
    public TaskAssignmentRecord() {}

    public TaskAssignmentRecord(VolunteerProfile volunteerProfile, Task task, String status) {
        this.volunteerProfile = volunteerProfile;
        this.task = task;
        this.status = status;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public VolunteerProfile getVolunteerProfile() { return volunteerProfile; }
    public void setVolunteerProfile(VolunteerProfile volunteerProfile) {
        this.volunteerProfile = volunteerProfile;
    }

    public Task getTask() { return task; }
    public void setTask(Task task) { this.task = task; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
