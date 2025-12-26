package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerProfileController {

    @GetMapping
    public String getAllVolunteers() {
        return "List of volunteers";
    }

    @GetMapping("/{id}")
    public String getVolunteer(@PathVariable Long id) {
        return "Volunteer profile";
    }

    @PutMapping("/{id}/availability")
    public String updateAvailability(
            @PathVariable Long id,
            @RequestParam String availability) {
        return "Availability updated";
    }
}
