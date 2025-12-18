package com.example.demo.service.impl;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import com.example.demo.service.VolunteerSkillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerSkillServiceImpl implements VolunteerSkillService {

    private final VolunteerSkillRecordRepository repository;

    public VolunteerSkillServiceImpl(VolunteerSkillRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public VolunteerSkillRecord save(VolunteerSkillRecord record) {
        return repository.save(record);
    }

    @Override
    public List<VolunteerSkillRecord> getAll() {
        return repository.findAll();
    }

    @Override
    public VolunteerSkillRecord getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("VolunteerSkill not found"));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
