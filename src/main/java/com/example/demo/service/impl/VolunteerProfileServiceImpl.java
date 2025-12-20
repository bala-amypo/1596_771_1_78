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
        return repository.save(profile);
    }

    public VolunteerProfile getByVolunteerId(String volunteerId) {
        return repository.findByVolunteerId(volunteerId);
    }

    public List<VolunteerProfile> getAll() {
        return repository.findAll();
    }
}
