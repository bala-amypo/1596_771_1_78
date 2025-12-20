package com.example.demo.service.impl;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    private final TaskAssignmentRecordRepository repository;

    // ✅ Constructor Injection ONLY
    public TaskAssignmentServiceImpl(TaskAssignmentRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public TaskAssignmentRecord assignTask(Long taskId) {
        // simple auto-assign (dummy volunteerId)
        Long volunteerId = 1L;

        TaskAssignmentRecord assignment =
                new TaskAssignmentRecord(taskId, volunteerId);

        return repository.save(assignment);
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
    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId) {
        return repository.findByVolunteerId(volunteerId);
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId) {
        return repository.findByTaskId(taskId);
    }

    @Override
    public List<TaskAssignmentRecord> getAllAssignments() {
        return repository.findAll();
    }
}
