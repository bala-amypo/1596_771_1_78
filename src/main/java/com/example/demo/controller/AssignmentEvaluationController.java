package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/evaluations")
public class AssignmentEvaluationController {

    // POST /api/evaluations/{assignmentId}
    @PostMapping("/{assignmentId}")
    public String createEvaluation(@PathVariable Long assignmentId) {
        return "Evaluation created for assignment " + assignmentId;
    }

    // GET /api/evaluations/volunteer/{volunteerId}
    @GetMapping("/volunteer/{volunteerId}")
    public String getEvaluationsByVolunteer(@PathVariable Long volunteerId) {
        return "Evaluations for volunteer " + volunteerId;
    }
}
