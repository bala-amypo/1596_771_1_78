// package com.example.demo.service.impl;

// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.AssignmentEvaluationRecord;
// import com.example.demo.model.TaskAssignmentRecord;
// import com.example.demo.repository.AssignmentEvaluationRecordRepository;
// import com.example.demo.repository.TaskAssignmentRecordRepository;
// import com.example.demo.service.AssignmentEvaluationService;
// import org.springframework.stereotype.Service;
// import java.util.List;
// @Service
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
//     public AssignmentEvaluationRecord evaluateAssignment(AssignmentEvaluationRecord evaluation) {

//         TaskAssignmentRecord assignment = assignmentRepo.findById(
//                 evaluation.getAssignmentId())
//                 .orElseThrow(() -> new ResourceNotFoundException("Assignment not found"));

//         if (!"COMPLETED".equals(assignment.getStatus()))
//             throw new BadRequestException("ACTIVE assignment");

//         return evalRepo.save(evaluation);
//     }

//     @Override
//     public List<AssignmentEvaluationRecord> getEvaluationsByAssignment(Long assignmentId) {
//         return evalRepo.findByAssignmentId(assignmentId);
//     }

//     @Override
//     public List<AssignmentEvaluationRecord> getAllEvaluations() {
//         return evalRepo.findAll();
//     }
// }

package com.example.demo.service.impl;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.repository.AssignmentEvaluationRecordRepository;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class AssignmentEvaluationServiceImpl implements AssignmentEvaluationService {
private final AssignmentEvaluationRecordRepository evaluationRepository;
private final TaskAssignmentRecordRepository assignmentRepository;
public AssignmentEvaluationServiceImpl(
AssignmentEvaluationRecordRepository evaluationRepository,
TaskAssignmentRecordRepository assignmentRepository) {
this.evaluationRepository = evaluationRepository;
this.assignmentRepository = assignmentRepository;
}
@Override
public AssignmentEvaluationRecord evaluateAssignment(AssignmentEvaluationRecord evaluation)
{
TaskAssignmentRecord assignment =
assignmentRepository.findById(evaluation.getAssignmentId())
.orElseThrow(() -> new ResourceNotFoundException("Assignment not found"));
if (!"COMPLETED".equals(assignment.getStatus())) {
throw new BadRequestException("Assignment must be COMPLETED before evaluation");
}

package com.example.demo.service.impl;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.repository.AssignmentEvaluationRecordRepository;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class AssignmentEvaluationServiceImpl implements AssignmentEvaluationService {
private final AssignmentEvaluationRecordRepository evaluationRepository;
private final TaskAssignmentRecordRepository assignmentRepository;
public AssignmentEvaluationServiceImpl(
AssignmentEvaluationRecordRepository evaluationRepository,
TaskAssignmentRecordRepository assignmentRepository) {
this.evaluationRepository = evaluationRepository;
this.assignmentRepository = assignmentRepository;
}
@Override
public AssignmentEvaluationRecord evaluateAssignment(AssignmentEvaluationRecord evaluation)
{
TaskAssignmentRecord assignment =
assignmentRepository.findById(evaluation.getAssignmentId())
.orElseThrow(() -> new ResourceNotFoundException("Assignment not found"));
if (!"COMPLETED".equals(assignment.getStatus())) {
throw new BadRequestException("Assignment must be COMPLETED before evaluation");
}
