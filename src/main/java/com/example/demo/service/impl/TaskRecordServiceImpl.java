package com.example.demo.service.impl;

import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.service.TaskRecordService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskRecordServiceImpl implements TaskRecordService {

    private final TaskRecordRepository repository;

    public TaskRecordServiceImpl(TaskRecordRepository repository) {
        this.repository = repository;
    }

    public TaskRecord createTask(TaskRecord task) {
        return repository.save(task);
    }

    public TaskRecord updateTask(Long id, TaskRecord updated) {
        TaskRecord task = repository.findById(id).orElseThrow();
        task.setTaskCode(updated.getTaskCode());
        task.setTaskName(updated.getTaskName());
        task.setStatus(updated.getStatus());
        return repository.save(task);
    }

    public TaskRecord getTaskByCode(String code) {
        return repository.findByTaskCode(code).orElseThrow();
    }

    public List<TaskRecord> getOpenTasks() {
        return repository.findByStatus("OPEN");
    }

    public List<TaskRecord> getAllTasks() {
        return repository.findAll();
    }
}
