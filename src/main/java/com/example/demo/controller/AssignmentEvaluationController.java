// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/evaluations")
// public class AssignmentEvaluationController {

//     // POST /api/evaluations/{assignmentId}
//     @PostMapping("/{assignmentId}")
//     public String createEvaluation(@PathVariable Long assignmentId) {
//         return "Evaluation created for assignment " + assignmentId;
//     }

//     // GET /api/evaluations/volunteer/{volunteerId}
//     @GetMapping("/volunteer/{volunteerId}")
//     public String getEvaluationsByVolunteer(@PathVariable Long volunteerId) {
//         return "Evaluations for volunteer " + volunteerId;
//     }
// }

package com.example.demo.controller;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
public class AssignmentEvaluationController {

    private final AssignmentEvaluationService evaluationService;

    @Autowired
    public AssignmentEvaluationController(AssignmentEvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    // Matches POST /api/evaluations/{assignmentId}
    @PostMapping("/{assignmentId}")
    public ResponseEntity<AssignmentEvaluationRecord> createEvaluation(
            @PathVariable Long assignmentId, 
            @RequestBody AssignmentEvaluationRecord evaluation) {
        
        // Ensure the ID from path is set on the record [cite: 1, 9]
        evaluation.setAssignmentId(assignmentId);
        
        AssignmentEvaluationRecord saved = evaluationService.evaluateAssignment(evaluation);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    /}
    @GetMapping("/assignment/{assignmentId}")
    public ResponseEntity<List<AssignmentEvaluationRecord>> getEvaluationsByAssignment(
            @PathVariable Long assignmentId) {
        
        List<AssignmentEvaluationRecord> evaluations = evaluationService.getEvaluationsByAssignment(assignmentId);
        return ResponseEntity.ok(evaluations);
    }

    // Matches GET /api/evaluations/volunteer/{volunteerId}
    @GetMapping("/volunteer/{volunteerId}")
    public ResponseEntity<String> getEvaluationsByVolunteer(@PathVariable Long volunteerId) {
        return ResponseEntity.ok("Evaluations for volunteer " + volunteerId);
    }
}
