// package com.example.demo.repository;

// import com.example.demo.model.TaskRecord;
// import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.List;
// import java.util.Optional;

// public interface TaskRecordRepository extends JpaRepository<TaskRecord, Long> {

//     boolean existsByTaskCode(String taskCode);

//     Optional<TaskRecord> findByTaskCode(String taskCode);

//     List<TaskRecord> findByStatus(String status);
// }


package com.example.demo.repository;

import com.example.demo.model.TaskRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRecordRepository extends JpaRepository<TaskRecord, Long> {

    // ✅ Valid: status exists in entity
    List<TaskRecord> findByStatus(String status);

    // ✅ Optional useful methods
    List<TaskRecord> findByRequiredSkill(String requiredSkill);

    List<TaskRecord> findByRequiredSkillLevel(int requiredSkillLevel);
}
