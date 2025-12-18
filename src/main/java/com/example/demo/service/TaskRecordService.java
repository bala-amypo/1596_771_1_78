package com.example.demo.service;

import com.example.demo.model.TaskAssignmentRecord;

public interface TaskRecordService {
    TaskAssignmentRecord assignTask(Long taskId, Long volunteerId);
}
