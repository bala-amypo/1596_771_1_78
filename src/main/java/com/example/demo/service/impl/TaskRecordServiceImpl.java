package com.example.demo.service.impl;

import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.service.TaskRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskRecordServiceImpl implements TaskRecordService {

    @Autowired
    private TaskRecordRepository repository;

    // ---------------- BASIC CRUD ----------------

    @Override
    public TaskRecord saveTask(TaskRecord task) {
        return repository.save(task);
    }

    @Override
    public List<TaskRecord> getAllTasks() {
        return repository.findAll();
    }

    @Override
    public TaskRecord getTaskById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    @Override
    public TaskRecord updateTask(Long id, TaskRecord updated) {
        TaskRecord task = getTaskById(id);

        task.setTaskName(updated.getTaskName());
        task.setDescription(updated.getDescription());
        task.setStatus(updated.getStatus());
        task.setPriority(updated.getPriority());

        return repository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    // ---------------- CONTROLLER REQUIRED ----------------

    @Override
    public TaskRecord createTask(TaskRecord task) {
        // just reuse saveTask
        return repository.save(task);
    }

    @Override
    public List<TaskRecord> getOpenTasks() {
        // "OPEN" means status != Completed
        return repository.findAll()
                .stream()
                .filter(task -> !"Completed".equalsIgnoreCase(task.getStatus()))
                .collect(Collectors.toList());
    }
}
