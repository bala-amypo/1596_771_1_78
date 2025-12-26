// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/volunteers")
// public class VolunteerProfileController {

//     @GetMapping
//     public String getAllVolunteers() {
//         return "List of volunteers";
//     }

//     @GetMapping("/{id}")
//     public String getVolunteer(@PathVariable Long id) {
//         return "Volunteer profile";
//     }

//     @PutMapping("/{id}/availability")
//     public String updateAvailability(
//             @PathVariable Long id,
//             @RequestParam String availability) {
//         return "Availability updated";
//     }
// }

package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerProfileController {

    // 1. POST / - Create volunteer
    @PostMapping
    public String createVolunteer(@RequestBody String volunteerData) {
        return "Volunteer created successfully";
    }

    // 2. GET /{id} - Get volunteer
    @GetMapping("/{id}")
    public String getVolunteer(@PathVariable Long id) {
        return "Volunteer profile for ID: " + id;
    }

    // 3. GET / - List all
    @GetMapping
    public String getAllVolunteers() {
        return "List of all volunteers";
    }

    // 4. PUT /{id}/availability - Update status
    @PutMapping("/{id}/availability")
    public String updateAvailability(
            @PathVariable Long id,
            @RequestParam String availability) {
        return "Availability updated for volunteer " + id + " to: " + availability;
    }

    // 5. GET /lookup/{volunteerId} - Lookup by ID
    @GetMapping("/lookup/{volunteerId}")
    public String lookupVolunteer(@PathVariable Long volunteerId) {
        return "Lookup details for volunteer: " + volunteerId;
    }
}