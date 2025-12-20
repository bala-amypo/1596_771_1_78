package com.example.demo.service;

import com.example.demo.model.TaskAssignmentRecord;
import java.util.List;

public interface TaskAssignmentService {

    TaskAssignmentRecord assignTask(Long taskId, String volunteerId);

    TaskAssignmentRecord updateStatus(Long id, String status);

    List<TaskAssignmentRecord> getByVolunteer(String volunteerId);

    List<TaskAssignmentRecord> getByTask(Long taskId);

    List<TaskAssignmentRecord> getAll();
}
