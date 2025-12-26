// package com.example.demo.controller;

// import com.example.demo.model.VolunteerSkillRecord;
// import com.example.demo.service.VolunteerSkillService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/volunteer-skills")
// public class VolunteerSkillController {

//     @Autowired
//     private VolunteerSkillService volunteerSkillService;

//     @PostMapping
//     public VolunteerSkillRecord addSkill(
//             @RequestBody VolunteerSkillRecord skill) {
//         return volunteerSkillService.addOrUpdateSkill(skill);
//     }

//     @GetMapping("/volunteer/{volunteerId}")
//     public List<VolunteerSkillRecord> getSkills(
//             @PathVariable Long volunteerId) {
//         return volunteerSkillService.getSkillsByVolunteer(volunteerId);
//     }
// }


package com.example.demo.controller;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills") // Updated to match image: (/api/skills)
public class VolunteerSkillController {

    @Autowired
    private VolunteerSkillService volunteerSkillService;

    // 1. POST / - Add/update skill
    @PostMapping
    public VolunteerSkillRecord addSkill(@RequestBody VolunteerSkillRecord skill) {
        return volunteerSkillService.addOrUpdateSkill(skill);
    }

    // 2. GET /volunteer/{volunteerId} - Get skills for a specific volunteer
    @GetMapping("/volunteer/{volunteerId}")
    public List<VolunteerSkillRecord> getSkills(@PathVariable Long volunteerId) {
        return volunteerSkillService.getSkillsByVolunteer(volunteerId);
    }

    // 3. GET /{id} - Get a specific skill by its ID
    @GetMapping("/{id}")
    public VolunteerSkillRecord getSkillById(@PathVariable Long id) {
        return volunteerSkillService.getSkillById(id);
    }

    // 4. GET / - List all skills
    @GetMapping
    public List<VolunteerSkillRecord> getAllSkills() {
        return volunteerSkillService.getAllSkills();
    }
}