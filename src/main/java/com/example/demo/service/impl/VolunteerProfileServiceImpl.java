package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;

@Service
public class VolunteerProfileServiceImpl implements VolunteerProfileService {

    @Autowired
    private VolunteerProfileRepository repository;

    public VolunteerProfile createVolunteer(VolunteerProfile profile) {
        return repository.save(profile);
    }

    public VolunteerProfile getVolunteerById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<VolunteerProfile> getAllVolunteers() {
        return repository.findAll();
    }

    public VolunteerProfile findByVolunteerId(String volunteerId) {
        return repository.findByVolunteerId(volunteerId);
    }

    public VolunteerProfile updateAvailability(Long id, String status) {
        VolunteerProfile v = getVolunteerById(id);
        if (v != null) {
            v.setAvailabilityStatus(status);
            return repository.save(v);
        }
        return null;
    }
}
