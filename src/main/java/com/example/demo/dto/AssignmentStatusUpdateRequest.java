package com.example.demo.dto;
public class AssignmentStatusUpdateRequest {
private Long assignmentId;
private String status;
public AssignmentStatusUpdateRequest() {}
public Long getAssignmentId() { return assignmentId; }
public void setAssignmentId(Long assignmentId) { this.assignmentId = assignmentId; }
public String getStatus() { return status; }
public void setStatus(String status) { this.status = status; }
}