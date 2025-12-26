// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/tasks")
// public class TaskRecordController {

//     @PostMapping
//     public String createTask() {
//         return "Task created";
//     }

//     @GetMapping("/open")
//     public String getOpenTasks() {
//         return "Open tasks";
//     }

//     @GetMapping("/{id}")
//     public String getTaskById(@PathVariable Long id) {
//         return "Task details";
//     }
// }


package com.example.demo.controller;

import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks") // Base path as per requirement: (/api/tasks)
public class TaskRecordController {

    @Autowired
    private TaskRecordService taskRecordService;

    // 1. POST / - Create task
    @PostMapping
    public TaskRecord createTask(@RequestBody TaskRecord task) {
        return taskRecordService.createTask(task);
    }

    // 2. PUT /{id} - Update task
    @PutMapping("/{id}")
    public TaskRecord updateTask(@PathVariable Long id, @RequestBody TaskRecord task) {
        return taskRecordService.updateTask(id, task);
    }

    // 3. GET /open - List open tasks
    @GetMapping("/open")
    public List<TaskRecord> getOpenTasks() {
        return taskRecordService.getOpenTasks();
    }

    // 4. GET /{id} - Get task
    @GetMapping("/{id}")
    public TaskRecord getTaskById(@PathVariable Long id) {
        return taskRecordService.getTaskById(id);
    }

    // 5. GET / - List all
    @GetMapping
    public List<TaskRecord> getAllTasks() {
        return taskRecordService.getAllTasks();
    }
}