package com.example.demo.service;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.repository.AssignmentEvaluationRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AssignmentEvaluationServiceImpl implements AssignmentEvaluationService {

    private final AssignmentEvaluationRecordRepository repository;

    // Constructor injection
    public AssignmentEvaluationServiceImpl(
            AssignmentEvaluationRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public AssignmentEvaluationRecord evaluateAssignment(
            AssignmentEvaluationRecord evaluation) {

        evaluation.setEvaluatedAt(LocalDateTime.now());
        return repository.save(evaluation);
    }

    @Override
    public List<AssignmentEvaluationRecord> getEvaluationsByAssignment(
            Long assignmentId) {
        return repository.findByAssignmentId(assignmentId);
    }

    @Override
    public List<AssignmentEvaluationRecord> getAllEvaluations() {
        return repository.findAll();
    }
}
