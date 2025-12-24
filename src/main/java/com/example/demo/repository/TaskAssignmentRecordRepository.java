package com.example.demo.repository;

import com.example.demo.model.TaskAssignmentRecord;
import java.util.List;
import java.util.Optional;

public interface TaskAssignmentRecordRepository {

    TaskAssignmentRecord save(TaskAssignmentRecord record);

    Optional<TaskAssignmentRecord> findById(Long id);

    List<TaskAssignmentRecord> findAll();

    List<TaskAssignmentRecord> findByTaskId(Long taskId);

    List<TaskAssignmentRecord> findByVolunteerId(Long volunteerId);

    boolean existsByTaskIdAndStatus(Long taskId, String status);
}
