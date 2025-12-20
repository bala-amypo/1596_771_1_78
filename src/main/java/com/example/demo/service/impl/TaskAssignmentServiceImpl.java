package com.example.demo.service.impl;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    private final TaskAssignmentRecordRepository repository;

    public TaskAssignmentServiceImpl(TaskAssignmentRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public TaskAssignmentRecord autoAssign(Long taskId) {
        Long volunteerId = Math.abs(new Random().nextLong() % 1000);

        TaskAssignmentRecord record =
                new TaskAssignmentRecord(taskId, volunteerId, "ASSIGNED");

        return repository.save(record);
    }

    @Override
    public TaskAssignmentRecord updateStatus(Long id, String status) {
        TaskAssignmentRecord record = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));

        record.setStatus(status);
        return repository.save(record);
    }

    @Override
    public List<TaskAssignmentRecord> getByVolunteer(Long volunteerId) {
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
