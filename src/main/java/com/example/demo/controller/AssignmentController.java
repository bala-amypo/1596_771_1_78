package com.example.demo.controller;

import com.example.demo.dto.EvaluationRequest;
import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
public class EvaluationController {

    @Autowired
    private AssignmentEvaluationService evaluationService;

    // POST /api/evaluations/{assignmentId}
    @PostMapping("/{assignmentId}")
    public AssignmentEvaluationRecord createEvaluation(
            @PathVariable Long assignmentId,
            @RequestBody EvaluationRequest request) {

        AssignmentEvaluationRecord eval = new AssignmentEvaluationRecord();
        eval.setAssignmentId(assignmentId);
        eval.setRating(request.getRating());
        eval.setFeedback(request.getFeedback());

        return evaluationService.evaluateAssignment(eval);
    }

    // GET /api/evaluations/volunteer/{volunteerId}
    @GetMapping("/volunteer/{volunteerId}")
    public List<AssignmentEvaluationRecord> getEvaluationsForVolunteer(
            @PathVariable Long volunteerId) {

        return evaluationService.getEvaluationsByVolunteer(volunteerId);
    }
}
