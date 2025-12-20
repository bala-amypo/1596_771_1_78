package com.example.demo.service.impl;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    private final TaskAssignmentRecordRepository repository;

    public TaskAssignmentServiceImpl(TaskAssignmentRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public TaskAssignmentRecord assignTask(Long taskId, String volunteerId) {
        TaskAssignmentRecord record =
                new TaskAssignmentRecord(taskId, volunteerId, "ASSIGNED");
        return repository.save(record);
    }

    @Override
    public TaskAssignmentRecord updateStatus(Long id, String status) {
        TaskAssignmentRecord record = repository.findById(id).orElse(null);
        if (record != null) {
            record.setStatus(status);
            return repository.save(record);
        }
        return null;
    }

    @Override
    public List<TaskAssignmentRecord> getByVolunteer(String volunteerId) {
        return repository.findByVolunteerId(volunteerId);
    }

    @Override
    public List<TaskAssignmentRecord> getByTask(Long taskId) {
        return repository.findByTaskId(taskId);
    }

    @Override
    public List<TaskAssignmentRecord> getAll() {
        return repository.findAll();
    }
}
