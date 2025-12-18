package com.example.demo.service.impl;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import com.example.demo.service.TaskRecordService;
import com.example.demo.util.SkillLevelUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TaskRecordServiceImpl implements TaskRecordService {

    private final TaskAssignmentRecordRepository taskRepo;
    private final VolunteerSkillRecordRepository skillRepo;

    public TaskRecordServiceImpl(TaskAssignmentRecordRepository taskRepo,
                                 VolunteerSkillRecordRepository skillRepo) {
        this.taskRepo = taskRepo;
        this.skillRepo = skillRepo;
    }

    @Override
    public TaskAssignmentRecord assignTask(Long taskId, Long volunteerId) {

        skillRepo.findByVolunteerId(volunteerId)
                .orElseThrow(() -> new RuntimeException("Volunteer skill not found"));

        TaskAssignmentRecord ar = new TaskAssignmentRecord();
        ar.setTaskId(taskId);
        ar.setVolunteerId(volunteerId);
        ar.setStatus(SkillLevelUtil.ASSIGNED);
        ar.setAssignedAt(LocalDateTime.now());

        return taskRepo.save(ar);
    }
}
