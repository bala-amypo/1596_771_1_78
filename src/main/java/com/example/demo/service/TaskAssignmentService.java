package com.example.demo.service;

import com.example.demo.model.TaskAssignmentRecord;
import java.util.List;

public interface TaskAssignmentService {

    TaskAssignmentRecord autoAssign(Long taskId);

    TaskAssignmentRecord updateStatus(Long id, String status);

    List<TaskAssignmentRecord> getByVolunteer(Long volunteerId);

    List<TaskAssignmentRecord> getByTask(Long taskId);

    List<TaskAssignmentRecord> getAll();
}
