package com.example.demo.service;

import com.example.demo.model.AssignmentEvaluationRecord;
import java.util.List;

public interface AssignmentEvaluationService {

    AssignmentEvaluationRecord evaluate(AssignmentEvaluationRecord record);

    List<AssignmentEvaluationRecord> getByAssignment(Long assignmentId);
}
