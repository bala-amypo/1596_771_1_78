package com.example.demo.controller;

import com.example.demo.model.AssignmentEvaluation;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentEvaluationController {

    @Autowired
    private AssignmentEvaluationService assignmentEvaluationService;

    // Create assignment evaluation
    @PostMapping
    public ResponseEntity<AssignmentEvaluation> createAssignment(
            @RequestBody AssignmentEvaluation assignmentEvaluation) {
        return ResponseEntity.ok(
                assignmentEvaluationService.saveAssignment(assignmentEvaluation));
    }

    // Get all assignment evaluations
    @GetMapping
    public ResponseEntity<List<AssignmentEvaluation>> getAllAssignments() {
        return ResponseEntity.ok(
                assignmentEvaluationService.getAllAssignments());
    }

    // Get assignment by ID
    @GetMapping("/{id}")
    public ResponseEntity<AssignmentEvaluation> getAssignmentById(@PathVariable Long id) {
        return ResponseEntity.ok(
                assignmentEvaluationService.getAssignmentById(id));
    }

    // Update assignment
    @PutMapping("/{id}")
    public ResponseEntity<AssignmentEvaluation> updateAssignment(
            @PathVariable Long id,
            @RequestBody AssignmentEvaluation assignmentEvaluation) {
        return ResponseEntity.ok(
                assignmentEvaluationService.updateAssignment(id, assignmentEvaluation));
    }

    // Delete assignment
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAssignment(@PathVariable Long id) {
        assignmentEvaluationService.deleteAssignment(id);
        return ResponseEntity.ok("Assignment deleted successfully");
    }
}
