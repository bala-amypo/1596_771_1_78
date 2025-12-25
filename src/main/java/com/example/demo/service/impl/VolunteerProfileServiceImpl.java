package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;

import java.util.*;

public class VolunteerProfileServiceImpl implements VolunteerProfileService {

    private final VolunteerProfileRepository repo;

    public VolunteerProfileServiceImpl(VolunteerProfileRepository repo) {
        this.repo = repo;
    }

    public VolunteerProfile createVolunteer(VolunteerProfile v) {
        if (repo.existsByVolunteerId(v.getVolunteerId()))
            throw new BadRequestException("Volunteer ID already exists");

        if (repo.existsByEmail(v.getEmail()))
            throw new BadRequestException("Email already exists");

        if (repo.existsByPhone(v.getPhone()))
            throw new BadRequestException("Phone already exists");

        return repo.save(v);
    }

    public VolunteerProfile getVolunteerById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<VolunteerProfile> getAllVolunteers() {
        return repo.findAll();
    }

    public Optional<VolunteerProfile> findByVolunteerId(String id) {
        return repo.findByVolunteerId(id);
    }
}
