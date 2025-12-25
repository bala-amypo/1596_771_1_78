package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.repository.AssignmentEvaluationRecordRepository;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.service.AssignmentEvaluationService;

import java.util.List;

public class AssignmentEvaluationServiceImpl implements AssignmentEvaluationService {

    private final AssignmentEvaluationRecordRepository evalRepo;
    private final TaskAssignmentRecordRepository assignmentRepo;

    public AssignmentEvaluationServiceImpl(
            AssignmentEvaluationRecordRepository e,
            TaskAssignmentRecordRepository a) {
        this.evalRepo = e;
        this.assignmentRepo = a;
    }

    public AssignmentEvaluationRecord evaluateAssignment(AssignmentEvaluationRecord r) {
        TaskAssignmentRecord assignment =
                assignmentRepo.findById(r.getAssignmentId())
                        .orElseThrow(() -> new BadRequestException("Assignment not found"));

        return evalRepo.save(r);
    }

    public List<AssignmentEvaluationRecord> getEvaluationsByAssignment(Long id) {
        return evalRepo.findByAssignmentId(id);
    }
}
