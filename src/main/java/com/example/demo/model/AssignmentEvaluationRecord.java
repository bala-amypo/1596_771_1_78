package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "assignment_evaluation_records")
public class AssignmentEvaluationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;
    private String assignmentTitle;
    private Integer marks;
    private String remarks;

    public AssignmentEvaluationRecord() {}

    public AssignmentEvaluationRecord(String studentName, String assignmentTitle, Integer marks, String remarks) {
        this.studentName = studentName;
        this.assignmentTitle = assignmentTitle;
        this.marks = marks;
        this.remarks = remarks;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getAssignmentTitle() { return assignmentTitle; }
    public void setAssignmentTitle(String assignmentTitle) { this.assignmentTitle = assignmentTitle; }

    public Integer getMarks() { return marks; }
    public void setMarks(Integer marks) { this.marks = marks; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
}
