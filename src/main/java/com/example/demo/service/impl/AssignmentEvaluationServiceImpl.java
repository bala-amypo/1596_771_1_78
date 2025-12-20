package com.example.demo.service.impl;

import com.example.demo.model.AssignmentEvaluation;
import com.example.demo.repository.AssignmentEvaluationRepository;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentEvaluationServiceImpl implements AssignmentEvaluationService {

    @Autowired
    private AssignmentEvaluationRepository assignmentEvaluationRepository;

    @Override
    public AssignmentEvaluation saveAssignment(AssignmentEvaluation assignmentEvaluation) {
        return assignmentEvaluationRepository.save(assignmentEvaluation);
    }

    @Override
    public List<AssignmentEvaluation> getAllAssignments() {
        return assignmentEvaluationRepository.findAll();
    }

    @Override
    public AssignmentEvaluation getAssignmentById(Long id) {
        return assignmentEvaluationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found with id: " + id));
    }

    @Override
    public AssignmentEvaluation updateAssignment(Long id, AssignmentEvaluation assignmentEvaluation) {
        AssignmentEvaluation existingAssignment =
                assignmentEvaluationRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Assignment not found with id: " + id));

        existingAssignment.setStudentName(assignmentEvaluation.getStudentName());
        existingAssignment.setAssignmentTitle(assignmentEvaluation.getAssignmentTitle());
        existingAssignment.setMarks(assignmentEvaluation.getMarks());
        existingAssignment.setRemarks(assignmentEvaluation.getRemarks());

        return assignmentEvaluationRepository.save(existingAssignment);
    }

    @Override
    public void deleteAssignment(Long id) {
        assignmentEvaluationRepository.deleteById(id);
    }
}
