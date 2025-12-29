// package com.example.demo.service;

// import com.example.demo.model.TaskAssignmentRecord;

// import java.util.List;

// public interface TaskAssignmentService {

//     TaskAssignmentRecord assignTask(Long taskId);

//     TaskAssignmentRecord updateAssignmentStatus(Long id, String status);

//     List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId);

//     List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId);

//     List<TaskAssignmentRecord> getAllAssignments();
// }


package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.TaskAssignmentRecord;
import com.example.demo.repository.TaskAssignmentRecordRepository;

@Service
public class TaskAssignmentService {

    private final TaskAssignmentRecordRepository repo;

    public TaskAssignmentService(TaskAssignmentRecordRepository repo) {
        this.repo = repo;
    }

    public List<TaskAssignmentRecord> getTasksByVolunteer(Long volunteerId) {
        return repo.findByVolunteerProfile_Id(volunteerId);
    }
}
