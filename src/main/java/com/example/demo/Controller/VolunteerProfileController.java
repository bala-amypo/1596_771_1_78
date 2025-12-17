package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@RequestMapping("/api/volunteers")
@Tag(name = "Volunteer Profile")
public class VolunteerProfileController {

    @PostMapping
    public String createVolunteer(@RequestBody Object volunteer) {
        return "Volunteer created";
    }

    @GetMapping("/{id}")
    public String getVolunteer(@PathVariable Long id) {
        return "Get volunteer by id " + id;
    }

    @GetMapping
    public String listAllVolunteers() {
        return "List all volunteers";
    }

    @PutMapping("/{id}/availability")
    public String updateAvailability(@PathVariable Long id,
                                     @RequestParam boolean available) {
        return "Availability updated for volunteer " + id;
    }

    @GetMapping("/lookup/{volunteerId}")
    public String lookupByVolunteerId(@PathVariable Long volunteerId) {
        return "Lookup volunteer " + volunteerId;
    }
}
