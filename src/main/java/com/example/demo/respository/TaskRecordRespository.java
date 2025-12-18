package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.TaskRecord;

public interface TaskRecordRepository extends JpaRepository<TaskRecord, Long> {

    boolean existsByTaskCode(String taskCode);

    List<TaskRecord> findByStatus(String status);

    Optional<TaskRecord> findByTaskCode(String code);
}
