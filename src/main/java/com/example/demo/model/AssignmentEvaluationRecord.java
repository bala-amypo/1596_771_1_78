// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "assignment_evaluations")
// public class AssignmentEvaluationRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Long assignmentId;

//     private Integer rating; // 1–5

//     private String feedback;

//     private LocalDateTime evaluatedAt;

//     @PrePersist
//     public void prePersist() {
//         this.evaluatedAt = LocalDateTime.now();
//     }

//     // Getters & Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public Long getAssignmentId() { return assignmentId; }
//     public void setAssignmentId(Long assignmentId) { this.assignmentId = assignmentId; }

//     public Integer getRating() { return rating; }
//     public void setRating(Integer rating) { this.rating = rating; }

//     public String getFeedback() { return feedback; }
//     public void setFeedback(String feedback) { this.feedback = feedback; }

//     public LocalDateTime getEvaluatedAt() { return evaluatedAt; }
// }


package com.example.demo.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
public class AssignmentEvaluationRecord {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private Long assignmentId;
private Integer rating;
private String feedback;
private LocalDateTime evaluatedAt;
// REQUIRED BY JPA + TESTS
public AssignmentEvaluationRecord() {
this.evaluatedAt = LocalDateTime.now();
}
// REQUIRED BY CONTROLLER
public AssignmentEvaluationRecord(Long assignmentId,
Integer rating,
String feedback) {
this.assignmentId = assignmentId;
this.rating = rating;
this.feedback = feedback;
this.evaluatedAt = LocalDateTime.now();
}
// Getters and setters
public Long getId() {
return id;
}
public Long getAssignmentId() {
return assignmentId;
}
public void setAssignmentId(Long assignmentId) {
this.assignmentId = assignmentId;
}
public Integer getRating() {
return rating;
}
public void setRating(Integer rating) {
this.rating = rating;
}
public String getFeedback() {
return feedback;
}
public void setFeedback(String feedback) {
this.feedback = feedback;
}
public LocalDateTime getEvaluatedAt() {
return evaluatedAt;
}
public void setEvaluatedAt(LocalDateTime evaluatedAt) {
this.evaluatedAt = evaluatedAt;
}
}