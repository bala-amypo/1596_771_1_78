package com.example.demo.service;

import com.example.demo.model.AssignmentEvaluationRecord;
import java.util.List;

public interface AssignmentEvaluationService {
    AssignmentEvaluationRecord evaluateAssignment(AssignmentEvaluationRecord r);
    List<AssignmentEvaluationRecord> getEvaluationsByAssignment(Long id);
}
