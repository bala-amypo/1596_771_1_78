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
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public interface TaskRecordRepository extends JpaRepository<TaskRecord, Long> {
List<TaskRecord> findByStatus(String status);
Optional<TaskRecord> findByTaskCode(String taskCode);
}