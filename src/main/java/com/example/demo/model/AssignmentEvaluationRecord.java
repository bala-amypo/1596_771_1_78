package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class AssignmentEvaluationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long assignmentId;
    private Integer score;
    private String feedback;

    // getters & setters
}
