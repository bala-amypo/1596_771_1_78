package com.example.demo.controller;

import com.example.demo.dto.AssignmentStatusUpdateRequest;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class TaskAssignmentController {

    @Autowired
    private TaskAssignmentService taskAssignmentService;

    // POST /api/assignments/{volunteerId}/{taskId}
    @PostMapping("/{volunteerId}/{taskId}")
    public TaskAssignmentRecord assignTask(
            @PathVariable Long volunteerId,
            @PathVariable Long taskId) {

        return taskAssignmentService.assignTask(taskId);
    }

    // PUT /api/assignments/{id}/status
    @PutMapping("/{id}/status")
    public TaskAssignmentRecord updateStatus(
            @PathVariable Long id,
            @RequestBody AssignmentStatusUpdateRequest request) {

        return taskAssignmentService.updateStatus(id, request.getStatus());
    }

    // GET /api/assignments/volunteer/{volunteerId}
    @GetMapping("/volunteer/{volunteerId}")
    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(
            @PathVariable Long volunteerId) {

        return taskAssignmentService.getAssignmentsByVolunteer(volunteerId);
    }
}
