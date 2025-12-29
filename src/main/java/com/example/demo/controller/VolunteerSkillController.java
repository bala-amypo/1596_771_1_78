// package com.example.demo.controller;

// import com.example.demo.model.VolunteerSkillRecord;
// import com.example.demo.service.VolunteerSkillService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import io.swagger.v3.oas.annotations.security.SecurityRequirement;
// @RestController
// @RequestMapping("/skills")
// @SecurityRequirement(name="bearerAuth")
// public class VolunteerSkillController {

//     private final VolunteerSkillService service;

//     public VolunteerSkillController(VolunteerSkillService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public VolunteerSkillRecord save(@RequestBody VolunteerSkillRecord skill) {
//         return service.addOrUpdateSkill(skill);
//     }

//     @GetMapping
//     public List<VolunteerSkillRecord> all() {
//         return service.getAllSkills();
//     }

//     @GetMapping("/{id}")
//     public VolunteerSkillRecord get(@PathVariable Long id) {
//         return service.getSkillById(id);
//     }
// }


package com.example.demo.controller;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@Tag(name = "Volunteer Skills")
public class VolunteerSkillController {

    private final VolunteerSkillService volunteerSkillService;

    public VolunteerSkillController(VolunteerSkillService volunteerSkillService) {
        this.volunteerSkillService = volunteerSkillService;
    }

    @Operation(summary = "Add or update skill")
    @PostMapping
    public VolunteerSkillRecord addSkill(@RequestBody VolunteerSkillRecord skill) {
        return volunteerSkillService.addOrUpdateSkill(skill);
    }

    @Operation(summary = "Get skills by volunteer ID")
    @GetMapping("/volunteer/{volunteerId}")
    public List<VolunteerSkillRecord> getSkillsByVolunteer(@PathVariable Long volunteerId) {
        return volunteerSkillService.getSkillsByVolunteer(volunteerId);
    }

    @Operation(summary = "Get skill by ID")
    @GetMapping("/{id}")
    public VolunteerSkillRecord getSkill(@PathVariable Long id) {
        return volunteerSkillService.getSkillById(id);
    }

    @Operation(summary = "Get all skills")
    @GetMapping
    public List<VolunteerSkillRecord> getAllSkills() {
        return volunteerSkillService.getAllSkills();
    }
}
