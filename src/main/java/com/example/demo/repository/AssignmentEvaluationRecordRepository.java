// package com.example.demo.repository;

// import com.example.demo.model.AssignmentEvaluationRecord;
// import java.util.List;

// public interface AssignmentEvaluationRecordRepository {

//     AssignmentEvaluationRecord save(AssignmentEvaluationRecord record);

//     List<AssignmentEvaluationRecord> findByAssignmentId(Long assignmentId);
// }


package com.example.demo.repository;

import com.example.demo.model.AssignmentEvaluationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentEvaluationRecordRepository
        extends JpaRepository<AssignmentEvaluationRecord, Long> {

    List<AssignmentEvaluationRecord> findByAssignmentId(Long assignmentId);
}
