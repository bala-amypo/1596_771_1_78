package com.example.demo.service;

import com.example.demo.model.TaskRecord;
import java.util.List;

public interface TaskRecordService {

    // existing
    TaskRecord saveTask(TaskRecord task);
    List<TaskRecord> getAllTasks();
    TaskRecord getTaskById(Long id);
    TaskRecord updateTask(Long id, TaskRecord updated);
    void deleteTask(Long id);

    // 🔧 ADD THESE (for controller)
    TaskRecord createTask(TaskRecord task);
    List<TaskRecord> getOpenTasks();
}
