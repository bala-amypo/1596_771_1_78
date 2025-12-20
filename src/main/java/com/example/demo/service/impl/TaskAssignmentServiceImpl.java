package com.example.demo.service.impl;

import com.example.demo.model.TaskAssignment;
import com.example.demo.repository.TaskAssignmentRepository;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    private final TaskAssignmentRepository repository;

    public TaskAssignmentServiceImpl(TaskAssignmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public TaskAssignment autoAssign(Long taskId) {
        Long volunteerId = new Random().nextLong(100); // dummy volunteer
        TaskAssignment assignment =
                new TaskAssignment(taskId, volunteerId, "ASSIGNED");
        return repository.save(assignment);
    }

    @Override
    public TaskAssignment updateStatus(Long id, String status) {
        TaskAssignment assignment = repository.findById(id).orElseThrow();
        assignment.setStatus(status);
        return repository.save(assignment);
    }

    @Override
    public List<TaskAssignment> getByVolunteer(Long volunteerId) {
        return repository.findByVolunteerId(volunteerId);
    }

    @Override
    public List<TaskAssignment> getByTask(Long taskId) {
        return repository.findByTaskId(taskId);
    }

    @Override
    public List<TaskAssignment> getAll() {
        return repository.findAll();
    }
}
