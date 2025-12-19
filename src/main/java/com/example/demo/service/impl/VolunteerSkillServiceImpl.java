package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.VolunteerSkillRepository;
import com.example.demo.service.VolunteerSkillService;

@Service
public class VolunteerSkillServiceImpl implements VolunteerSkillService {

    @Autowired
    private VolunteerSkillRepository repository;

    @Override
    public VolunteerSkillRecord addSkill(VolunteerSkillRecord skill) {
        return repository.save(skill);
    }

    @Override
    public VolunteerSkillRecord getSkillById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<VolunteerSkillRecord> getSkillsByVolunteer(Long volunteerId) {
        return repository.findByVolunteerId(volunteerId);
    }

    @Override
    public List<VolunteerSkillRecord> getAllSkills() {
        return repository.findAll();
    }
}
