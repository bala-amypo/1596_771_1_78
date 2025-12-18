package com.example.demo.repository;

import com.example.demo.model.VolunteerSkillRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VolunteerSkillRecordRepository
        extends JpaRepository<VolunteerSkillRecord, Long> {

    Optional<VolunteerSkillRecord> findByVolunteerId(Long volunteerId);
}
