package com.example.demo.service;

import com.example.demo.model.VolunteerSkillRecord;
import java.util.List;

public interface VolunteerSkillService {
    VolunteerSkill save(VolunteerSkill skill);
    List<VolunteerSkill> getAll();
    VolunteerSkill getById(Long id);
    void delete(Long id);
}
