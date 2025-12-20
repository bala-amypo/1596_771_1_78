package com.example.demo.controller;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class TaskAssignmentController {

    private final TaskAssignmentService service;

    public TaskAssignmentController(TaskAssignmentService service) {
        this.service = service;
    }

    // POST /api/assignments/assign/{taskId}
    @PostMapping("/assign/{taskId}")
    public TaskAssignmentRecord assignTask(@PathVariable Long taskId) {
        return service.assignTask(taskId);
    }

    // PUT /api/assignments/{id}/status
    @PutMapping("/{id}/status")
    public TaskAssignmentRecord updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    // GET /api/assignments/volunteer/{volunteerId}
    @GetMapping("/volunteer/{volunteerId}")
    public List<TaskAssignmentRecord> byVolunteer(
            @PathVariable Long volunteerId) {
        return service.getAssignmentsByVolunteer(volunteerId);
    }

    // GET /api/assignments/task/{taskId}
    @GetMapping("/task/{taskId}")
    public List<TaskAssignmentRecord> byTask(
            @PathVariable Long taskId) {
        return service.getAssignmentsByTask(taskId);
    }

    // GET /api/assignments
    @GetMapping
    public List<TaskAssignmentRecord> getAll() {
        return service.getAllAssignments();
    }
}
