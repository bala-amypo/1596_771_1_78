package com.example.demo.controller;

import com.example.demo.model.TaskAssignment;
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

    @PostMapping("/assign/{taskId}")
    public TaskAssignment autoAssign(@PathVariable Long taskId) {
        return service.autoAssign(taskId);
    }

    @PutMapping("/{id}/status")
    public TaskAssignment updateStatus(@PathVariable Long id,
                                       @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    @GetMapping("/volunteer/{volunteerId}")
    public List<TaskAssignment> byVolunteer(@PathVariable Long volunteerId) {
        return service.getByVolunteer(volunteerId);
    }

    @GetMapping("/task/{taskId}")
    public List<TaskAssignment> byTask(@PathVariable Long taskId) {
        return service.getByTask(taskId);
    }

    @GetMapping
    public List<TaskAssignment> getAll() {
        return service.getAll();
    }
}
