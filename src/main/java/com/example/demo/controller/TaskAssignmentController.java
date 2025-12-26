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


package com.example.demo.controller;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/assignments") // Base path: /api/assignments
public class TaskAssignmentController {

    @Autowired
    private TaskAssignmentService taskAssignmentService;

    // 1. POST /assign/{taskId} - Auto-assign
    @PostMapping("/assign/{taskId}")
    public TaskAssignmentRecord autoAssign(@PathVariable Long taskId) {
        return taskAssignmentService.assignTask(taskId);
    }

    // 2. PUT /{id}/status - Update status
    @PutMapping("/{id}/status")
    public TaskAssignmentRecord updateStatus(
            @PathVariable Long id,
            @RequestBody Map<String, String> request) {
        return taskAssignmentService.updateAssignmentStatus(id, request.get("status"));
    }

    // 3. GET /volunteer/{volunteerId} - Get by volunteer
    @GetMapping("/volunteer/{volunteerId}")
    public List<TaskAssignmentRecord> getByVolunteer(@PathVariable Long volunteerId) {
        return taskAssignmentService.getAssignmentsByVolunteer(volunteerId);
    }

    // 4. GET /task/{taskId} - Get by task
    @GetMapping("/task/{taskId}")
    public List<TaskAssignmentRecord> getByTask(@PathVariable Long taskId) {
        return taskAssignmentService.getAssignmentsByTask(taskId);
    }

    // 5. GET / - List all
    @GetMapping
    public List<TaskAssignmentRecord> getAllAssignments() {
        return taskAssignmentService.getAllAssignments();
    }
}