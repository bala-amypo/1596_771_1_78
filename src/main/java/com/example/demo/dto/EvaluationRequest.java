package com.example.demo.dto;

public class EvaluationRequest {

    private Integer rating; // e.g., 1–5
    private String feedback;

    public EvaluationRequest() {}

    public EvaluationRequest(Integer rating, String feedback) {
        this.rating = rating;
        this.feedback = feedback;
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
}
