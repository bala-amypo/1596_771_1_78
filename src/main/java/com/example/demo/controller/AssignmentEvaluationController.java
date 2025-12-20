package com.example.demo.controller;

import com.example.demo.model.AssignmentEvaluationRecord;
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

    // Create a new assignment evaluation
    @PostMapping
    public ResponseEntity<AssignmentEvaluationRecord> createAssignment(
            @RequestBody AssignmentEvaluationRecord assignment) {
        return ResponseEntity.ok(assignmentEvaluationService.saveAssignment(assignment));
    }

    // Get all assignments
    @GetMapping
    public ResponseEntity<List<AssignmentEvaluationRecord>> getAllAssignments() {
        return ResponseEntity.ok(assignmentEvaluationService.getAllAssignments());
    }

    // Get assignment by ID
    @GetMapping("/{id}")
    public ResponseEntity<AssignmentEvaluationRecord> getAssignmentById(@PathVariable Long id) {
        return ResponseEntity.ok(assignmentEvaluationService.getAssignmentById(id));
    }

    // Update assignment by ID
    @PutMapping("/{id}")
    public ResponseEntity<AssignmentEvaluationRecord> updateAssignment(
            @PathVariable Long id,
            @RequestBody AssignmentEvaluationRecord assignment) {
        return ResponseEntity.ok(assignmentEvaluationService.updateAssignment(id, assignment));
    }

    // Delete assignment by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAssignment(@PathVariable Long id) {
        assignmentEvaluationService.deleteAssignment(id);
        return ResponseEntity.ok("Assignment deleted successfully");
    }
}
