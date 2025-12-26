// package com.example.demo.model;

// import java.time.LocalDateTime;

// public class AssignmentEvaluationRecord {
//     private Long assignmentId;
//     private Integer rating;
//     private String feedback;
//     private LocalDateTime evaluatedAt = LocalDateTime.now();

//     public Long getAssignmentId() { return assignmentId; }
//     public void setAssignmentId(Long assignmentId) { this.assignmentId = assignmentId; }

//     public Integer getRating() { return rating; }
//     public void setRating(Integer rating) { this.rating = rating; }

//     public String getFeedback() { return feedback; }
//     public void setFeedback(String feedback) { this.feedback = feedback; }

//     public LocalDateTime getEvaluatedAt() { return evaluatedAt; }
// }

package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.time.LocalDateTime;

@Entity
@Table(name = "assignment_evaluation_records")
public class AssignmentEvaluationRecord {

    @Id
    private Long assignmentId; // Assuming one evaluation per assignment

    private Integer rating;
    
    @Column(columnDefinition = "TEXT") // Good for longer feedback strings
    private String feedback;

    private LocalDateTime evaluatedAt = LocalDateTime.now();

    // Default Constructor
    public AssignmentEvaluationRecord() {}

    public Long getAssignmentId() { return assignmentId; }
    public void setAssignmentId(Long assignmentId) { this.assignmentId = assignmentId; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }

    public LocalDateTime getEvaluatedAt() { return evaluatedAt; }
    public void setEvaluatedAt(LocalDateTime evaluatedAt) { this.evaluatedAt = evaluatedAt; }
}