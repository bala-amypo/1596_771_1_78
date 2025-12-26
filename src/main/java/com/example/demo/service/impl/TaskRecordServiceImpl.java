// package com.example.demo.service.impl;

// import com.example.demo.model.TaskRecord;
// import com.example.demo.repository.TaskRecordRepository;
// import com.example.demo.service.TaskRecordService;

// import java.util.List;
// import java.util.Optional;

// public class TaskRecordServiceImpl implements TaskRecordService {

//     private final TaskRecordRepository repository;

//     public TaskRecordServiceImpl(TaskRecordRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public TaskRecord createTask(TaskRecord task) {
//         if (task.getStatus() == null) {
//             task.setStatus("OPEN");
//         }
//         return repository.save(task);
//     }

//     @Override
//     public TaskRecord updateTask(Long id, TaskRecord task) {
//         TaskRecord existing = repository.findById(id).orElseThrow();

//         existing.setTaskName(task.getTaskName());
//         existing.setRequiredSkill(task.getRequiredSkill());
//         existing.setRequiredSkillLevel(task.getRequiredSkillLevel());
//         existing.setPriority(task.getPriority());
//         existing.setStatus(task.getStatus());

//         return repository.save(existing);
//     }

//     @Override
//     public List<TaskRecord> getAllTasks() {
//         return repository.findAll();
//     }

//     @Override
//     public List<TaskRecord> getOpenTasks() {
//         return repository.findByStatus("OPEN");
//     }

//     @Override
//     public Optional<TaskRecord> getTaskByCode(String taskCode) {
//         return repository.findByTaskCode(taskCode);
//     }
// }


package com.example.demo.service.impl;

import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.service.TaskRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskRecordServiceImpl implements TaskRecordService {

    @Autowired
    private TaskRecordRepository taskRecordRepository;

    @Override
    public TaskRecord createTask(TaskRecord task) {
        return taskRecordRepository.save(task);
    }

    @Override
    public TaskRecord updateTask(Long id, TaskRecord task) {
        task.setId(id);
        return taskRecordRepository.save(task);
    }

    @Override
    public List<TaskRecord> getOpenTasks() {
        return taskRecordRepository.findByStatus("OPEN");
    }

    @Override
    public List<TaskRecord> getAllTasks() {
        return taskRecordRepository.findAll();
    }

    // FIX: This method must match the interface signature exactly
    @Override
    public TaskRecord getTaskById(Long id) {
        return taskRecordRepository.findById(id).orElse(null);
    }
}