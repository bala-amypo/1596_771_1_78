package com.example.demo.service;

import com.example.demo.model.TaskAssignment;
import java.util.List;

public interface TaskAssignmentService {

    TaskAssignment autoAssign(Long taskId);

    TaskAssignment updateStatus(Long id, String status);

    List<TaskAssignment> getByVolunteer(Long volunteerId);

    List<TaskAssignment> getByTask(Long taskId);

    List<TaskAssignment> getAll();
}
