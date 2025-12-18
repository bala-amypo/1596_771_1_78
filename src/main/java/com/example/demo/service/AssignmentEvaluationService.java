package com.example.demo.service;

import com.example.demo.model.AssignmentEvaluationRecord;
import java.util.List;

public interface AssignmentEvaluationService {

    List<AssignmentEvaluationRecord> getAll();

    AssignmentEvaluationRecord getById(Long id);

    AssignmentEvaluationRecord save(AssignmentEvaluationRecord record);

    void delete(Long id);
}
