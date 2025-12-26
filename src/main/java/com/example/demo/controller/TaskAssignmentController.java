package com.example.demo.controller;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/assignments")
public class TaskAssignmentController {

    @Autowired
    private TaskAssignmentService taskAssignmentService;

    @PostMapping("/{volunteerId}/{taskId}")
    public TaskAssignmentRecord assign(
            @PathVariable Long volunteerId,
            @PathVariable Long taskId) {

        return taskAssignmentService.assignTask(taskId);
    }

    @PutMapping("/{id}/status")
    public TaskAssignmentRecord updateStatus(
            @PathVariable Long id,
            @RequestBody Map<String, String> request) {

        return taskAssignmentService.updateStatus(id, request.get("status"));
    }

    @GetMapping("/volunteer/{volunteerId}")
    public List<TaskAssignmentRecord> byVolunteer(
            @PathVariable Long volunteerId) {

        return taskAssignmentService.getAssignmentsByVolunteer(volunteerId);
    }
}
