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
        TaskRecord task = repository.findById(id).orElse(null);
        if (task != null) {
            task.setTaskName(updated.getTaskName());
            task.setPriority(updated.getPriority());
            task.setStatus(updated.getStatus());
            return repository.save(task);
        }
        return null;
    }

    public List<TaskRecord> getOpenTasks() {
        return repository.findByStatus("OPEN");
    }

    public TaskRecord getTaskById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<TaskRecord> getAllTasks() {
        return repository.findAll();
    }
}
