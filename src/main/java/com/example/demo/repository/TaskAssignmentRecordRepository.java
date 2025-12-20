package com.example.demo.repository;

import com.example.demo.model.TaskAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskAssignmentRepository extends JpaRepository<TaskAssignment, Long> {

    List<TaskAssignment> findByVolunteerId(Long volunteerId);

    List<TaskAssignment> findByTaskId(Long taskId);
}
