package com.example.demo.service.impl;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.repository.AssignmentEvaluationRecordRepository;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentEvaluationServiceImpl implements AssignmentEvaluationService {

    @Autowired
    private AssignmentEvaluationRecordRepository repository;

    @Override
    public AssignmentEvaluationRecord saveAssignment(AssignmentEvaluationRecord assignment) {
        return repository.save(assignment);
    }

    @Override
    public List<AssignmentEvaluationRecord> getAllAssignments() {
        return repository.findAll();
    }

    @Override
    public AssignmentEvaluationRecord getAssignmentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found with id: " + id));
    }

    @Override
    public AssignmentEvaluationRecord updateAssignment(Long id, AssignmentEvaluationRecord assignment) {
        AssignmentEvaluationRecord existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found with id: " + id));

        existing.setStudentName(assignment.getStudentName());
        existing.setAssignmentTitle(assignment.getAssignmentTitle());
        existing.setMarks(assignment.getMarks());
        existing.setRemarks(assignment.getRemarks());

        return repository.save(existing);
    }

    @Override
    public void deleteAssignment(Long id) {
        repository.deleteById(id);
    }
}
