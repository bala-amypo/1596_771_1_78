package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.TaskAssignmentRecord;

public interface TaskAssignmentRecordRepository extends JpaRepository<TaskAssignmentRecord, Long> {

    boolean existsByTaskIdAndStatus(Long taskId, String status);

    List<TaskAssignmentRecord> findByTaskId(Long id);

    List<TaskAssignmentRecord> findByVolunteerId(Long id);
}
