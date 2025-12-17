package com.example.demo.controller;

import io.swagger.v3.oas.annotations.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
@Tag(name = "Tasks")
public class TaskRecordController {

    @PostMapping
    public String createTask(@RequestBody Object task) {
        return "Task created";
    }

    @PutMapping("/{id}")
    public String updateTask(@PathVariable Long id,
                             @RequestBody Object task) {
        return "Task updated " + id;
    }

    @GetMapping("/open")
    public String listOpenTasks() {
        return "List open tasks";
    }

    @GetMapping("/{id}")
    public String getTask(@PathVariable Long id) {
        return "Get task " + id;
    }

    @GetMapping
    public String listAllTasks() {
        return "List all tasks";
    }
}
