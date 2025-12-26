package com.example.demo.controller;

import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRecordService taskRecordService;

    // POST /api/tasks
    @PostMapping
    public TaskRecord createTask(@RequestBody TaskRecord task) {
        return taskRecordService.createTask(task);
    }

    // GET /api/tasks/open
    @GetMapping("/open")
    public List<TaskRecord> getOpenTasks() {
        return taskRecordService.getOpenTasks();
    }

    // GET /api/tasks/{id}
    @GetMapping("/{id}")
    public TaskRecord getTaskById(@PathVariable Long id) {
        return taskRecordService.getTaskById(id);
    }
}
