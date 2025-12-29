package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.TaskAssignmentRecord;

public interface TaskAssignmentRecordRepository
        extends JpaRepository<TaskAssignmentRecord, Long> {

    List<TaskAssignmentRecord> findByVolunteerProfile_Id(Long id);

    List<TaskAssignmentRecord> findByTaskRecord_Id(Long id);
}
