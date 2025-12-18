package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.repository.TaskAssignmentRecordRepository;

@Service
public class TaskRecordServiceImpl {

    private final TaskAssignmentRecordRepository repository;

    public TaskRecordServiceImpl(TaskAssignmentRecordRepository repository) {
        this.repository = repository;
    }
}
