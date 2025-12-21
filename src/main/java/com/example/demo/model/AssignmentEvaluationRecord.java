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

    public AssignmentEvaluationRecord() {
        this.evaluatedAt = LocalDateTime.now();
    }

    public AssignmentEvaluationRecord(Long assignmentId,
                                      Integer rating,
                                      String feedback) {
        this.assignmentId = assignmentId;
        this.rating = rating;
        this.feedback = feedback;
        this.evaluatedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Long getAssignmentId() { return assignmentId; }
    public Integer getRating() { return rating; }
    public String getFeedback() { return feedback; }
}
