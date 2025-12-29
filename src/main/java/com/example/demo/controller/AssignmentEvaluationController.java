// package com.example.demo.controller;

// import com.example.demo.model.AssignmentEvaluationRecord;
// import com.example.demo.service.AssignmentEvaluationService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import io.swagger.v3.oas.annotations.security.SecurityRequirement;

// @RestController
// @RequestMapping("/evaluations")
// @SecurityRequirement(name="bearerAuth")
// public class AssignmentEvaluationController {

//     private final AssignmentEvaluationService service;

//     public AssignmentEvaluationController(AssignmentEvaluationService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public AssignmentEvaluationRecord evaluate(
//             @RequestBody AssignmentEvaluationRecord evaluation) {

//         return service.evaluateAssignment(evaluation);
//     }

//     @GetMapping
//     public List<AssignmentEvaluationRecord> all() {
//         return service.getAllEvaluations();
//     }
// }

package com.example.demo.controller;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
@Tag(name = "Assignment Evaluations")
public class AssignmentEvaluationController {

    private final AssignmentEvaluationService evaluationService;

    public AssignmentEvaluationController(AssignmentEvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @Operation(summary = "Submit evaluation")
    @PostMapping
    public AssignmentEvaluationRecord evaluate(@RequestBody AssignmentEvaluationRecord record) {
        return evaluationService.evaluateAssignment(record);
    }

    @Operation(summary = "Get evaluations by assignment")
    @GetMapping("/assignment/{assignmentId}")
    public List<AssignmentEvaluationRecord> getByAssignment(@PathVariable Long assignmentId) {
        return evaluationService.getEvaluationsByAssignment(assignmentId);
    }

    @Operation(summary = "Get all evaluations")
    @GetMapping
    public List<AssignmentEvaluationRecord> getAllEvaluations() {
        return evaluationService.getAllEvaluations();
    }
}
