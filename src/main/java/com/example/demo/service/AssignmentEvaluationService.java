package com.example.demo.service;

import com.example.demo.model.AssignmentEvaluationRecord;
import java.util.List;

public interface AssignmentEvaluationService {

    AssignmentEvaluationRecord saveAssignment(AssignmentEvaluationRecord assignment);

    List<AssignmentEvaluationRecord> getAllAssignments();

    AssignmentEvaluationRecord getAssignmentById(Long id);

    AssignmentEvaluationRecord updateAssignment(Long id, AssignmentEvaluationRecord assignment);

    void deleteAssignment(Long id);
}
