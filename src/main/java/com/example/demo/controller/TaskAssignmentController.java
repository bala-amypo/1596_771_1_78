package com.example.demo.controller;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task-assignments")
public class TaskAssignmentController {

    private final TaskAssignmentService service;

    public TaskAssignmentController(TaskAssignmentService service) {
        this.service = service;
    }

    @PostMapping("/assign")
    public TaskAssignmentRecord assign(
            @RequestParam Long taskId,
            @RequestParam String volunteerId) {
        return service.assignTask(taskId, volunteerId);
    }

    @PutMapping("/{id}/status")
    public TaskAssignmentRecord updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    @GetMapping("/volunteer/{volunteerId}")
    public List<TaskAssignmentRecord> byVolunteer(
            @PathVariable String volunteerId) {
        return service.getByVolunteer(volunteerId);
    }

    @GetMapping("/task/{taskId}")
    public List<TaskAssignmentRecord> byTask(
            @PathVariable Long taskId) {
        return service.getByTask(taskId);
    }

    @GetMapping
    public List<TaskAssignmentRecord> all() {
        return service.getAll();
    }
}
