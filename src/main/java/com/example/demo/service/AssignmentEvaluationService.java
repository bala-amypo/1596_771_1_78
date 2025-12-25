package com.example.demo.service;

import com.example.demo.model.AssignmentEvaluation;
import java.util.List;

public interface AssignmentEvaluationService {

    AssignmentEvaluation create(AssignmentEvaluation evaluation);

    List<AssignmentEvaluation> getAll();

    AssignmentEvaluation getById(Long id);

    AssignmentEvaluation update(Long id, AssignmentEvaluation evaluation);

    void delete(Long id);
}
