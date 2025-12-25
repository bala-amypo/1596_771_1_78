package com.example.demo.service.impl;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import com.example.demo.service.VolunteerSkillService;

import java.time.LocalDateTime;
import java.util.List;

public class VolunteerSkillServiceImpl implements VolunteerSkillService {

    private final VolunteerSkillRecordRepository repo;

    public VolunteerSkillServiceImpl(VolunteerSkillRecordRepository repo) {
        this.repo = repo;
    }

    public VolunteerSkillRecord addOrUpdateSkill(VolunteerSkillRecord s) {
        s.setUpdatedAt(LocalDateTime.now());
        return repo.save(s);
    }

    public List<VolunteerSkillRecord> getSkillsByVolunteer(Long id) {
        return repo.findByVolunteerId(id);
    }
}
