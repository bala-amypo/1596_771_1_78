package com.example.demo.repository;

import com.example.demo.model.AssignmentEvaluationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentEvaluationRecordRepository extends JpaRepository<AssignmentEvaluationRecord, Long> {
}
