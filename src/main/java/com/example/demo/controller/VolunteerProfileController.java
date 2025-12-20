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

    // POST /api/volunteers
    @PostMapping
    public VolunteerProfile create(@RequestBody VolunteerProfile profile) {
        return service.createVolunteer(profile);
    }

    // GET /api/volunteers/{volunteerId}
    @GetMapping("/{volunteerId}")
    public VolunteerProfile getByVolunteerId(@PathVariable String volunteerId) {
        return service.getByVolunteerId(volunteerId);
    }

    // GET /api/volunteers
    @GetMapping
    public List<VolunteerProfile> getAll() {
        return service.getAllVolunteers();
    }
}
