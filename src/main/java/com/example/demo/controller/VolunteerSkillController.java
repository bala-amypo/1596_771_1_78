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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class VolunteerSkillController {

    private final VolunteerSkillService volunteerSkillService;

    @Autowired
    public VolunteerSkillController(VolunteerSkillService volunteerSkillService) {
        this.volunteerSkillService = volunteerSkillService;
    }

    // POST / - Add/update skill
    @PostMapping
    public ResponseEntity<VolunteerSkillRecord> addOrUpdateSkill(@RequestBody VolunteerSkillRecord skill) {
        // Now works because save() is in the Interface
        return ResponseEntity.ok(volunteerSkillService.save(skill));
    }

    // GET /volunteer/{volunteerId} - Get skills for a specific volunteer
    @GetMapping("/volunteer/{volunteerId}")
    public ResponseEntity<List<VolunteerSkillRecord>> getSkillsByVolunteer(@PathVariable Long volunteerId) {
        return ResponseEntity.ok(volunteerSkillService.getSkillsByVolunteer(volunteerId));
    }

    // GET /{id} - Get a specific skill by its ID
    @GetMapping("/{id}")
    public ResponseEntity<VolunteerSkillRecord> getSkillById(@PathVariable Long id) {
        // Now works because findById() is in the Interface 
        // AND we use .orElseThrow() to handle the Optional
        VolunteerSkillRecord record = volunteerSkillService.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found with id: " + id));
        
        return ResponseEntity.ok(record);
    }

    // GET / - List all skills
    @GetMapping
    public ResponseEntity<List<VolunteerSkillRecord>> listAll() {
        return ResponseEntity.ok(volunteerSkillService.getAllSkills());
    }
}