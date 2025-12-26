package com.example.demo.controller;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerController {

    @Autowired
    private VolunteerProfileService volunteerProfileService;

    @GetMapping
    public List<VolunteerProfile> getAllVolunteers() {
        return volunteerProfileService.getAllVolunteers();
    }

    @GetMapping("/{id}")
    public VolunteerProfile getVolunteer(@PathVariable Long id) {
        return volunteerProfileService.getVolunteerById(id);
    }

    @PutMapping("/{id}/availability")
    public VolunteerProfile updateAvailability(
            @PathVariable Long id,
            @RequestBody Map<String, String> request) {

        VolunteerProfile profile =
                volunteerProfileService.getVolunteerById(id);
        profile.setAvailabilityStatus(request.get("availabilityStatus"));
        return profile; // no updateVolunteer() exists
    }
}
