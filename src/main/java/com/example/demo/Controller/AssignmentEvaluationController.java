package com.example.demo.controller;

import io.swagger.v3.oas.annotations.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/evaluations")
@Tag(name = "Assignment Evaluations")
public class AssignmentEvaluationController {

    @PostMapping
    public String submitEvaluation(@RequestBody Object evaluation) {
        return "Evaluation submitted";
    }

    @GetMapping("/assignment/{assignmentId}")
    public String getByAssignment(@PathVariable Long assignmentId) {
        return "Evaluation for assignment " + assignmentId;
    }

    @GetMapping
    public String listAllEvaluations() {
        return "List all evaluations";
    }
}
