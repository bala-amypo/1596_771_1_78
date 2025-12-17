package com.example.demo.model;

import java.time.LocalDateTime;

public class AssignmentEvalaution {
    private long id;
    private long assignmentId;
    private int rating;
    private String feedback;
    private LocalDateTime evaluatedAt;
}
public AssignmentEvalaution(){

}
public AssignmentEvalaution(long id, long assignmentId, int rating, String feedback, LocalDateTime evaluatedAt) {
    this.id = id;
    this.assignmentId = assignmentId;
    this.rating = rating;
    this.feedback = feedback;
    this.evaluatedAt = evaluatedAt;
}
public long getAssignmentId() {
    return assignmentId;
}
public int getRating() {
    return rating;
}
public String getFeedback() {
    return feedback;
}
public LocalDateTime getEvaluatedAt() {
    return evaluatedAt;
}
public void setAssignmentId(long assignmentId) {
    this.assignmentId = assignmentId;
}
public void setRating(int rating) {
    this.rating = rating;
}
public void setFeedback(String feedback) {
    this.feedback = feedback;
}
public void setEvaluatedAt(LocalDateTime evaluatedAt) {
    this.evaluatedAt = evaluatedAt;
}
