// package com.example.demo.repository;

// import com.example.demo.model.TaskRecord;
// import java.util.List;
// import java.util.Optional;

// public interface TaskRecordRepository {

//     TaskRecord save(TaskRecord task);

//     Optional<TaskRecord> findById(Long id);

//     Optional<TaskRecord> findByTaskCode(String taskCode);

//     List<TaskRecord> findAll();

//     List<TaskRecord> findByStatus(String status);
// }
package com.example.demo.repository;

import com.example.demo.model.TaskRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRecordRepository
        extends JpaRepository<TaskRecord, Long> {

    Optional<TaskRecord> findByTaskCode(String taskCode);

    List<TaskRecord> findByStatus(String status);
}
