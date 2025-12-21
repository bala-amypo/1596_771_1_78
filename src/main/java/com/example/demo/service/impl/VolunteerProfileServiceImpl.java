package com.example.demo.service.impl;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VolunteerProfileServiceImpl implements VolunteerProfileService {

    private final VolunteerProfileRepository repository;

    public VolunteerProfileServiceImpl(VolunteerProfileRepository repository) {
        this.repository = repository;
    }

    public VolunteerProfile createVolunteer(VolunteerProfile profile) {

        if (repository.existsByEmail(profile.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        if (repository.existsByPhone(profile.getPhone())) {
            throw new RuntimeException("Phone already exists");
        }
        return repository.save(profile);
    }

    public VolunteerProfile getVolunteerById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public VolunteerProfile findByVolunteerId(String volunteerId) {
        return repository.findByVolunteerId(volunteerId).orElseThrow();
    }

    public List<VolunteerProfile> getAllVolunteers() {
        return repository.findAll();
    }

    public VolunteerProfile updateAvailability(Long id, String status) {
        VolunteerProfile v = getVolunteerById(id);
        v.setAvailabilityStatus(status);
        return repository.save(v);
    }
}
