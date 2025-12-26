package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.AssignmentEvaluationService;

@Service
public class AssignmentEvaluationServiceImpl implements AssignmentEvaluationService {

    @Override
    public String evaluateAssignment(Long assignmentId) {
        // Simple dummy logic
        if (assignmentId == null) {
            return "Assignment ID is null";
        }
        return "Assignment " + assignmentId + " evaluated successfully";
    }
}
