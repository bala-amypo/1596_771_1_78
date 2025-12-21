package com.example.demo.service.impl;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.repository.AssignmentEvaluationRecordRepository;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AssignmentEvaluationServiceImpl implements AssignmentEvaluationService {

    private final AssignmentEvaluationRecordRepository evalRepo;
    private final TaskAssignmentRecordRepository assignmentRepo;

    public AssignmentEvaluationServiceImpl(
            AssignmentEvaluationRecordRepository evalRepo,
            TaskAssignmentRecordRepository assignmentRepo) {
        this.evalRepo = evalRepo;
        this.assignmentRepo = assignmentRepo;
    }

    public AssignmentEvaluationRecord evaluateAssignment(
            AssignmentEvaluationRecord evaluation) {
        return evalRepo.save(evaluation);
    }

    public List<AssignmentEvaluationRecord> getEvaluationsByAssignment(Long assignmentId) {
        return evalRepo.findByAssignmentId(assignmentId);
    }

    public List<AssignmentEvaluationRecord> getAllEvaluations() {
        return evalRepo.findAll();
    }
}
