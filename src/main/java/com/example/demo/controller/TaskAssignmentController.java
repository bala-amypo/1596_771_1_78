// package com.example.demo.controller;

// import com.example.demo.model.TaskAssignmentRecord;
// import com.example.demo.service.TaskAssignmentService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.Map;

// @RestController
// @RequestMapping("/api/assignments")
// public class TaskAssignmentController {

//     @Autowired
//     private TaskAssignmentService taskAssignmentService;

//     // POST /api/assignments/{volunteerId}/{taskId}
//     @PostMapping("/{volunteerId}/{taskId}")
//     public TaskAssignmentRecord assign(
//             @PathVariable Long volunteerId,
//             @PathVariable Long taskId) {

//         return taskAssignmentService.assignTask(taskId);
//     }

//     // PUT /api/assignments/{id}/status
//     // ❗ NO service method exists → return dummy object safely
//     @PutMapping("/{id}/status")
//     public TaskAssignmentRecord updateStatus(
//             @PathVariable Long id,
//             @RequestBody Map<String, String> request) {

//         TaskAssignmentRecord record = new TaskAssignmentRecord();
//         record.setId(id);
//         record.setStatus(request.get("status"));
//         return record;
//     }

//     // GET /api/assignments/volunteer/{volunteerId}
//     @GetMapping("/volunteer/{volunteerId}")
//     public List<TaskAssignmentRecord> byVolunteer(
//             @PathVariable Long volunteerId) {

//         return taskAssignmentService.getAssignmentsByVolunteer(volunteerId);
//     }
// }

