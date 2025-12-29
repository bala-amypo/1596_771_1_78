// package com.example.demo.controller;

// import com.example.demo.model.VolunteerProfile;
// import com.example.demo.service.VolunteerProfileService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import io.swagger.v3.oas.annotations.security.SecurityRequirement;
// @RestController
// @RequestMapping("/volunteers")
// @SecurityRequirement(name="bearerAuth")
// public class VolunteerProfileController {

//     private final VolunteerProfileService service;

//     public VolunteerProfileController(VolunteerProfileService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public VolunteerProfile create(@RequestBody VolunteerProfile profile) {
//         return service.createVolunteer(profile);
//     }

//     @GetMapping("/{id}")
//     public VolunteerProfile get(@PathVariable Long id) {
//         return service.getVolunteerById(id);
//     }

//     @GetMapping
//     public List<VolunteerProfile> all() {
//         return service.getAllVolunteers();
//     }

//     @PutMapping("/{id}/availability")
//     public VolunteerProfile updateAvailability(
//             @PathVariable Long id,
//             @RequestParam String status) {

//         return service.updateAvailability(id, status);
//     }
// }

package com.example.demo.controller;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteers")
@Tag(name = "Volunteer Profile")
public class VolunteerProfileController {

    private final VolunteerProfileService volunteerProfileService;

    public VolunteerProfileController(VolunteerProfileService volunteerProfileService) {
        this.volunteerProfileService = volunteerProfileService;
    }

    @Operation(summary = "Create volunteer")
    @PostMapping
    public VolunteerProfile createVolunteer(@RequestBody VolunteerProfile profile) {
        return volunteerProfileService.createVolunteer(profile);
    }

    @Operation(summary = "Get volunteer by ID")
    @GetMapping("/{id}")
    public VolunteerProfile getVolunteer(@PathVariable Long id) {
        return volunteerProfileService.getVolunteerById(id);
    }

    @Operation(summary = "Get all volunteers")
    @GetMapping
    public List<VolunteerProfile> getAllVolunteers() {
        return volunteerProfileService.getAllVolunteers();
    }

    @Operation(summary = "Update availability status")
    @PutMapping("/{id}/availability")
    public VolunteerProfile updateAvailability(
            @PathVariable Long id,
            @RequestParam String status) {
        return volunteerProfileService.updateAvailability(id, status);
    }

    @Operation(summary = "Find volunteer by volunteerId")
    @GetMapping("/lookup/{volunteerId}")
    public VolunteerProfile findByVolunteerId(@PathVariable String volunteerId) {
        return volunteerProfileService.findByVolunteerId(volunteerId);
    }
}
