package com.example.demo.controller;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import com.example.demo.dto.AvailabilityUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerController {

    @Autowired
    private VolunteerProfileService volunteerProfileService;

    // GET /api/volunteers
    @GetMapping
    public List<VolunteerProfile> getAllVolunteers() {
        return volunteerProfileService.getAllVolunteers();
    }

    // GET /api/volunteers/{id}
    @GetMapping("/{id}")
    public VolunteerProfile getVolunteerById(@PathVariable Long id) {
        return volunteerProfileService.getVolunteerById(id);
    }

    // PUT /api/volunteers/{id}/availability
    @PutMapping("/{id}/availability")
    public VolunteerProfile updateAvailability(
            @PathVariable Long id,
            @RequestBody AvailabilityUpdateRequest request) {

        VolunteerProfile profile = volunteerProfileService.getVolunteerById(id);
        profile.setAvailabilityStatus(request.getAvailabilityStatus());
        return volunteerProfileService.updateVolunteer(profile);
    }
}
