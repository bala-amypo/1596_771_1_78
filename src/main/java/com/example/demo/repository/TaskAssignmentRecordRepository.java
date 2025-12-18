package com.example.demo.repository;

import com.example.demo.model.TaskAssignmentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskAssignmentRecordRepository
        extends JpaRepository<TaskAssignmentRecord, Long> {
}
