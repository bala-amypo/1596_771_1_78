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

        // Dummy evaluation logic
        if (record == null) {
            return null;
        }

        // Example: set evaluation result
        record.setRemarks("Evaluated successfully");
        record.setScore(85);

        return record;
    }

    @Override
    public List<AssignmentEvaluationRecord> getEvaluationsByAssignment(Long assignmentId) {

        List<AssignmentEvaluationRecord> evaluations = new ArrayList<>();

        if (assignmentId == null) {
            return evaluations;
        }

        // Dummy data (replace with DB logic later)
        AssignmentEvaluationRecord record1 = new AssignmentEvaluationRecord();
        record1.setAssignmentId(assignmentId);
        record1.setScore(80);
        record1.setRemarks("Good work");

        AssignmentEvaluationRecord record2 = new AssignmentEvaluationRecord();
        record2.setAssignmentId(assignmentId);
        record2.setScore(90);
        record2.setRemarks("Excellent work");

        evaluations.add(record1);
        evaluations.add(record2);

        return evaluations;
    }
}
