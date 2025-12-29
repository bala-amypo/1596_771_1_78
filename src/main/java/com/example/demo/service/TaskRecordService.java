// package com.example.demo.service;

// import com.example.demo.model.TaskRecord;

// import java.util.List;
// import java.util.Optional;

// public interface TaskRecordService {

//     TaskRecord createTask(TaskRecord task);

//     TaskRecord updateTask(Long id, TaskRecord updated);

//     List<TaskRecord> getOpenTasks();

//     Optional<TaskRecord> getTaskByCode(String code);

//     List<TaskRecord> getAllTasks();
// }


package com.example.demo.service;

import com.example.demo.model.TaskRecord;
import java.util.List;

public interface TaskRecordService {

    TaskRecord createTask(TaskRecord task);

    TaskRecord updateTask(Long taskId, TaskRecord task);

    List<TaskRecord> getOpenTasks();

    TaskRecord getTaskById(Long taskId);

    List<TaskRecord> getAllTasks();
}
