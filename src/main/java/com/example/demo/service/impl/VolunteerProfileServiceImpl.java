package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;

@Service
public class VolunteerProfileServiceImpl implements VolunteerProfileService {

    @Autowired
    private VolunteerProfileRepository repository;

    @Override
    public VolunteerProfile createVolunteer(VolunteerProfile profile) {
        return repository.save(profile);
    }

    @Override
    public VolunteerProfile getVolunteerById(Long id) {
        // Throws exception if not found
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("VolunteerProfile not found with id: " + id));
    }

    @Override
    public List<VolunteerProfile> getAllVolunteers() {
        return repository.findAll();
    }

    @Override
    public VolunteerProfile findByVolunteerId(String volunteerId) {
        Optional<VolunteerProfile> optionalProfile = repository.findByVolunteerId(volunteerId);
        return optionalProfile.orElseThrow(
                () -> new RuntimeException("VolunteerProfile not found with volunteerId: " + volunteerId));
    }

    @Override
    public VolunteerProfile updateAvailability(Long id, String status) {
        VolunteerProfile v = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("VolunteerProfile not found with id: " + id));

        v.setAvailabilityStatus(status);
        return repository.save(v);
    }
}
