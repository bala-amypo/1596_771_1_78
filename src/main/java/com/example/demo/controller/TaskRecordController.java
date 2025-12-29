// package com.example.demo.controller;

// import com.example.demo.model.TaskRecord;
// import com.example.demo.service.TaskRecordService;
// import org.spriAngframework.web.bind.annotation.*;

// import java.util.List;
// import io.swagger.v3.oas.annotations.security.SecurityRequirement;
// @RestController
// @RequestMapping("/tasks")
// @SecurityRequirement(name="bearerAuth")
// public class TaskRecordController {

//     private final TaskRecordService service;

//     public TaskRecordController(TaskRecordService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public TaskRecord create(@RequestBody TaskRecord task) {
//         return service.createTask(task);
//     }

//     @PutMapping("/{id}")
//     public TaskRecord update(
//             @PathVariable Long id,
//             @RequestBody TaskRecord task) {

//         return service.updateTask(id, task);
//     }

//     @GetMapping
//     public List<TaskRecord> all() {
//         return service.getAllTasks();
//     }

//     @GetMapping("/open")
//     public List<TaskRecord> openTasks() {
//         return service.getOpenTasks();
//     }
// }

package com.example.demo.controller;

import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@Tag(name = "Tasks")
public class TaskRecordController {

    private final TaskRecordService taskRecordService;

    public TaskRecordController(TaskRecordService taskRecordService) {
        this.taskRecordService = taskRecordService;
    }

    @Operation(summary = "Create task")
    @PostMapping
    public TaskRecord createTask(@RequestBody TaskRecord task) {
        return taskRecordService.createTask(task);
    }

    @Operation(summary = "Update task")
    @PutMapping("/{id}")
    public TaskRecord updateTask(@PathVariable Long id, @RequestBody TaskRecord task) {
        return taskRecordService.updateTask(id, task);
    }

    @Operation(summary = "Get open tasks")
    @GetMapping("/open")
    public List<TaskRecord> getOpenTasks() {
        return taskRecordService.getOpenTasks();
    }

    @Operation(summary = "Get task by ID")
    @GetMapping("/{id}")
    public TaskRecord getTask(@PathVariable Long id) {
        return taskRecordService.getTaskById(id);
    }

    @Operation(summary = "Get all tasks")
    @GetMapping
    public List<TaskRecord> getAllTasks() {
        return taskRecordService.getAllTasks();
    }
}
