package com.example.demo.controller;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerProfileController {

    private final VolunteerProfileService service;

    public VolunteerProfileController(VolunteerProfileService service) {
        this.service = service;
    }

    @PostMapping
    public VolunteerProfile create(@RequestBody VolunteerProfile profile) {
        return service.createVolunteer(profile);
    }

    @GetMapping("/{volunteerId}")
    public VolunteerProfile get(@PathVariable String volunteerId) {
        return service.getByVolunteerId(volunteerId);
    }

    @GetMapping
    public List<VolunteerProfile> all() {
        return service.getAll();
    }
}
