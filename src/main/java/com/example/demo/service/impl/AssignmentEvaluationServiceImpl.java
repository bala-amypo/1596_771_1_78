package com.example.demo.service;

import com.example.demo.repository.AssignmentEvaluationRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class AssignmentEvaluationServiceImpl {

    private final AssignmentEvaluationRecordRepository repository;

    public AssignmentEvaluationServiceImpl(
            AssignmentEvaluationRecordRepository repository) {
        this.repository = repository;
    }
}
