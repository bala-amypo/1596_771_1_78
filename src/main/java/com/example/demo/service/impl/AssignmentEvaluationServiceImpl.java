// package com.example.demo.service.impl;

// import com.example.demo.exception.BadRequestException;
// import com.example.demo.model.AssignmentEvaluationRecord;
// import com.example.demo.repository.AssignmentEvaluationRecordRepository;
// import com.example.demo.repository.TaskAssignmentRecordRepository;
// import com.example.demo.service.AssignmentEvaluationService;

// import java.util.List;

// public class AssignmentEvaluationServiceImpl implements AssignmentEvaluationService {

//     private final AssignmentEvaluationRecordRepository evalRepo;
//     private final TaskAssignmentRecordRepository assignmentRepo;

//     public AssignmentEvaluationServiceImpl(
//             AssignmentEvaluationRecordRepository evalRepo,
//             TaskAssignmentRecordRepository assignmentRepo) {
//         this.evalRepo = evalRepo;
//         this.assignmentRepo = assignmentRepo;
//     }

//     @Override
//     public AssignmentEvaluationRecord evaluateAssignment(
//             AssignmentEvaluationRecord record) {

//         assignmentRepo.findById(record.getAssignmentId())
//                 .orElseThrow(() -> new BadRequestException("Assignment not found"));

//         return evalRepo.save(record);
//     }

//     @Override
//     public List<AssignmentEvaluationRecord> getEvaluationsByAssignment(Long assignmentId) {
//         return evalRepo.findByAssignmentId(assignmentId);
//     }
// }


package com.example.demo.service.impl;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.repository.AssignmentEvaluationRecordRepository;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDateTime;

@Service // This annotation fixes the "bean not found" error
public class AssignmentEvaluationServiceImpl implements AssignmentEvaluationService {

    private final AssignmentEvaluationRecordRepository evaluationRepository;
    private final TaskAssignmentRecordRepository assignmentRepository;

    @Autowired
    public AssignmentEvaluationServiceImpl(AssignmentEvaluationRecordRepository evaluationRepository,
                                           TaskAssignmentRecordRepository assignmentRepository) {
        this.evaluationRepository = evaluationRepository;
        this.assignmentRepository = assignmentRepository;
    }

    @Override
    public AssignmentEvaluationRecord evaluateAssignment(AssignmentEvaluationRecord evaluation) {
        // Set timestamp as required by test: testEvaluationRecordAutoTimestamp
        evaluation.setEvaluatedAt(LocalDateTime.now());
        return evaluationRepository.save(evaluation);
    }

    @Override
    public List<AssignmentEvaluationRecord> getEvaluationsByAssignment(Long assignmentId) {
        return evaluationRepository.findByAssignmentId(assignmentId);
    }
}