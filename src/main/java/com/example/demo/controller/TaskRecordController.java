package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskRecordController {

    @PostMapping
    public String createTask() {
        return "Task created";
    }

    @GetMapping("/open")
    public String getOpenTasks() {
        return "Open tasks";
    }

    @GetMapping("/{id}")
    public String getTaskById(@PathVariable Long id) {
        return "Task details";
    }
}
