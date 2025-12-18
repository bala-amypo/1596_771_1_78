package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerProfileServiceImpl implements VolunteerProfileService {

    private final VolunteerProfileRepository repository;

    // EXACT constructor signature required
    public VolunteerProfileServiceImpl(VolunteerProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public VolunteerProfile createVolunteer(VolunteerProfile profile) {
        if (repository.existsByEmail(profile.getEmail())) {
            throw new BadRequestException("Email already exists");
        }
        if (repository.existsByPhone(profile.getPhone())) {
            throw new BadRequestException("Phone already exists");
        }
        if (repository.existsByVolunteerId(profile.getVolunteerId())) {
            throw new BadRequestException("VolunteerId already exists");
        }
        return repository.save(profile);
    }

    @Override
    public VolunteerProfile getVolunteerById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Volunteer not found"));
    }

    @Override
    public List<VolunteerProfile> getAllVolunteers() {
        return repository.findAll();
    }

    @Override
    public VolunteerProfile findByVolunteerId(String volunteerId) {
        return repository.findByVolunteerId(volunteerId)
                .orElseThrow(() -> new ResourceNotFoundException("Volunteer not found"));
    }

    @Override
    public VolunteerProfile updateAvailability(Long id, String availabilityStatus) {
        VolunteerProfile v = getVolunteerById(id);
        v.setAvailabilityStatus(availabilityStatus);
        return repository.save(v);
    }
}
