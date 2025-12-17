package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/assignments")
@Tag(name = "Task Assignments")
public class TaskAssignmentController {

    @PostMapping("/assign/{taskId}")
    public String autoAssign(@PathVariable Long taskId) {
        return "Auto-assigned task " + taskId;
    }

    @PutMapping("/{id}/status")
    public String updateAssignmentStatus(@PathVariable Long id,
                                         @RequestParam String status) {
        return "Assignment status updated " + id;
    }

    @GetMapping("/volunteer/{volunteerId}")
    public String getByVolunteer(@PathVariable Long volunteerId) {
        return "Assignments for volunteer " + volunteerId;
    }

    @GetMapping("/task/{taskId}")
    public String getByTask(@PathVariable Long taskId) {
        return "Assignments for task " + taskId;
    }

    @GetMapping
    public String listAllAssignments() {
        return "List all assignments";
    }
}
