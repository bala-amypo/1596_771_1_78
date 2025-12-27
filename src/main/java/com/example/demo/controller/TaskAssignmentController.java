// package com.example.demo.controller;

// import com.example.demo.model.TaskAssignmentRecord;
// import com.example.demo.service.TaskAssignmentService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/assignments")
// public class TaskAssignmentController {

//     private final TaskAssignmentService service;

//     public TaskAssignmentController(TaskAssignmentService service) {
//         this.service = service;
//     }

//     @PostMapping("/{taskId}")
//     public TaskAssignmentRecord assign(@PathVariable Long taskId) {
//         return service.assignTask(taskId);
//     }

//     @PutMapping("/{id}/status")
//     public TaskAssignmentRecord updateStatus(
//             @PathVariable Long id,
//             @RequestParam String status) {

//         return service.updateAssignmentStatus(id, status);
//     }

//     @GetMapping
//     public List<TaskAssignmentRecord> all() {
//         return service.getAllAssignments();
//     }
// }


package com.example.demo.controller;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/assignments")
public class TaskAssignmentController {
private final TaskAssignmentService assignmentService;
public TaskAssignmentController(TaskAssignmentService assignmentService) {
this.assignmentService = assignmentService;
}
@GetMapping("/task/{taskId}")
public ResponseEntity<List<TaskAssignmentRecord>> getAssignmentsByTask(@PathVariable Long taskId) {
List<TaskAssignmentRecord> assignments = assignmentService.getAssignmentsByTask(taskId);
return ResponseEntity.ok(assignments);
}
@GetMapping("/volunteer/{volunteerId}")
public ResponseEntity<List<TaskAssignmentRecord>> getAssignmentsByVolunteer(@PathVariable Long volunteerId) {
List<TaskAssignmentRecord> assignments = assignmentService.getAssignmentsByVolunteer(volunteerId);
return ResponseEntity.ok(assignments);
}
}