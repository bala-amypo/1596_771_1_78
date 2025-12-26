package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;

@Service
public class AssignmentEvaluationServiceImpl implements AssignmentEvaluationService {

    @Override
    public AssignmentEvaluationRecord evaluateAssignment(AssignmentEvaluationRecord record) {
        // No setters used → safe
        return record;
    }

    @Override
    public List<AssignmentEvaluationRecord> getEvaluationsByAssignment(Long assignmentId) {

        List<AssignmentEvaluationRecord> evaluations = new ArrayList<>();

        // Dummy empty records (no setters)
        evaluations.add(new AssignmentEvaluationRecord());
        evaluations.add(new AssignmentEvaluationRecord());

        return evaluations;
    }
}
