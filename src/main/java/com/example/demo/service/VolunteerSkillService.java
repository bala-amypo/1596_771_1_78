package com.example.demo.service;

import com.example.demo.model.VolunteerSkillRecord;

import java.util.List;

public interface VolunteerSkillService {

    VolunteerSkillRecord save(VolunteerSkillRecord record);

    List<VolunteerSkillRecord> getAll();

    VolunteerSkillRecord getById(Long id);

    void delete(Long id);
}
