package com.example.demo.service;

import com.example.demo.model.TaskRecord;
import java.util.*;

public interface TaskRecordService {
    TaskRecord createTask(TaskRecord t);
    TaskRecord updateTask(Long id, TaskRecord t);
    List<TaskRecord> getOpenTasks();
    List<TaskRecord> getAllTasks();
    Optional<TaskRecord> getTaskByCode(String code);
}
