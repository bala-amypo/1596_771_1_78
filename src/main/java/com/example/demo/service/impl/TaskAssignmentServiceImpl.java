package com.example.demo.service.impl;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskAssignmentServiceImpl {

    private final VolunteerSkillRecordRepository skillRepository;

    public TaskAssignmentServiceImpl(
            VolunteerSkillRecordRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public TaskAssignmentRecord assignTask(Long volunteerId) {
        TaskAssignmentRecord ar = new TaskAssignmentRecord();
        ar.setVolunteerId(volunteerId);
        return ar;
    }
}
