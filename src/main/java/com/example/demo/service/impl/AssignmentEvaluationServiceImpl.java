package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AssignmentEvaluation;
import com.example.demo.repository.AssignmentEvaluationRepository;
import com.example.demo.service.AssignmentEvaluationService;

@Service
public class AssignmentEvaluationServiceImpl implements AssignmentEvaluationService {

    @Autowired
    private AssignmentEvaluationRepository repository;

    @Override
    public AssignmentEvaluation create(AssignmentEvaluation evaluation) {
        return repository.save(evaluation);
    }

    @Override
    public List<AssignmentEvaluation> getAll() {
        return repository.findAll();
    }

    @Override
    public AssignmentEvaluation getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluation not found"));
    }

    @Override
    public AssignmentEvaluation update(Long id, AssignmentEvaluation evaluation) {
        AssignmentEvaluation existing = getById(id);

        existing.setMarks(evaluation.getMarks());
        existing.setRemarks(evaluation.getRemarks());
        existing.setStudentName(evaluation.getStudentName());

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
