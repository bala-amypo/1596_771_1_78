package com.example.demo.controller;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/evaluations")
public class EvaluationController {

    @Autowired
    private AssignmentEvaluationService evaluationService;

    @PostMapping("/{assignmentId}")
    public AssignmentEvaluationRecord evaluate(
            @PathVariable Long assignmentId,
            @RequestBody Map<String, Object> request) {

        AssignmentEvaluationRecord eval =
                new AssignmentEvaluationRecord();
        eval.setAssignmentId(assignmentId);
        eval.setRating((Integer) request.get("rating"));
        eval.setFeedback((String) request.get("feedback"));

        return evaluationService.evaluateAssignment(eval);
    }

    @GetMapping("/assignment/{assignmentId}")
    public List<AssignmentEvaluationRecord> byAssignment(
            @PathVariable Long assignmentId) {

        return evaluationService.getEvaluationsByAssignment(assignmentId);
    }
}
