// package com.example.demo.repository;

// import com.example.demo.model.TaskAssignmentRecord;
// import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.List;

// public interface TaskAssignmentRecordRepository
//         extends JpaRepository<TaskAssignmentRecord, Long> {

//     boolean existsByTaskIdAndStatus(Long taskId, String status);

//     List<TaskAssignmentRecord> findByTaskId(Long taskId);

//     List<TaskAssignmentRecord> findByVolunteerId(Long volunteerId);
// }

package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.TaskAssignmentRecord;

public interface TaskAssignmentRecordRepository 
        extends JpaRepository<TaskAssignmentRecord, Long> {

    // ✅ CORRECT
    List<TaskAssignmentRecord> findByVolunteerProfile_Id(Long id);
}
