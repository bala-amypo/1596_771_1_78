// package com.example.demo.repository;

// import com.example.demo.model.VolunteerSkillRecord;
// import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.List;

// public interface VolunteerSkillRecordRepository
//         extends JpaRepository<VolunteerSkillRecord, Long> {

//     List<VolunteerSkillRecord> findByVolunteerId(Long volunteerId);

//     List<VolunteerSkillRecord> findBySkillName(String skillName);

//     List<VolunteerSkillRecord> findBySkillNameAndSkillLevel(
//             String skillName,
//             String skillLevel
//     );
// }


package com.example.demo.controller;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteer-skills")
public class VolunteerSkillController {

    private final VolunteerSkillService volunteerSkillService;

    public VolunteerSkillController(VolunteerSkillService volunteerSkillService) {
        this.volunteerSkillService = volunteerSkillService;
    }

    @PostMapping
    public VolunteerSkillRecord addOrUpdateSkill(
            @RequestBody VolunteerSkillRecord skill) {
        return volunteerSkillService.addOrUpdateSkill(skill);
    }

    @GetMapping("/volunteer/{volunteerId}")
    public List<VolunteerSkillRecord> getSkillsByVolunteer(
            @PathVariable Long volunteerId) {
        return volunteerSkillService.getSkillsByVolunteer(volunteerId);
    }

    @GetMapping("/{id}")
    public VolunteerSkillRecord getSkillById(@PathVariable Long id) {
        return volunteerSkillService.getSkillById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
    }
}
