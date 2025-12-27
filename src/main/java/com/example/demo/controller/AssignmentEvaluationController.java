// package com.example.demo.controller;

// import com.example.demo.model.AssignmentEvaluationRecord;
// import com.example.demo.service.AssignmentEvaluationService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/evaluations")
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
import com.example.demo.dto.EvaluationRequest;
import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/evaluations")
public class AssignmentEvaluationController {
private final AssignmentEvaluationService evaluationService;
public AssignmentEvaluationController(AssignmentEvaluationService evaluationService) {
this.evaluationService = evaluationService;
}
@PostMapping
public ResponseEntity<AssignmentEvaluationRecord> evaluateAssignment(@RequestBody EvaluationRequest request) {
AssignmentEvaluationRecord evaluation = new AssignmentEvaluationRecord(
request.getAssignmentId(),
request.getRating(),
request.getComments()
);
AssignmentEvaluationRecord result = evaluationService.evaluateAssignment(evaluation);
return ResponseEntity.ok(result);
}
}