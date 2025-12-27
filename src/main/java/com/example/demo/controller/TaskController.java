// package com.example.demo.controller;

// import com.example.demo.model.TaskRecord;
// import com.example.demo.service.TaskRecordService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/tasks")
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
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskAssignmentService;
import com.example.demo.service.TaskRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/tasks")
public class TaskController {
private final TaskRecordService taskService;
private final TaskAssignmentService assignmentService;
public TaskController(TaskRecordService taskService, TaskAssignmentService assignmentService) {
this.taskService = taskService;
this.assignmentService = assignmentService;
}
@PostMapping
public ResponseEntity<TaskRecord> createTask(@RequestBody TaskRecord task) {
TaskRecord createdTask = taskService.createTask(task);
return ResponseEntity.ok(createdTask);
}
@PostMapping("/{taskId}/assign")
public ResponseEntity<TaskAssignmentRecord> assignTask(@PathVariable Long taskId) {
TaskAssignmentRecord assignment = assignmentService.assignTask(taskId);
return ResponseEntity.ok(assignment);
}
}