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

    @PostMapping
    public TaskRecord create(@RequestBody TaskRecord task) {
        return taskRecordService.createTask(task);
    }

    @GetMapping("/open")
    public List<TaskRecord> openTasks() {
        return taskRecordService.getOpenTasks();
    }
}
