package com.example.demo.controller;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteer-skills")
public class VolunteerSkillController {

    @Autowired
    private VolunteerSkillService volunteerSkillService;

    @PostMapping
    public VolunteerSkillRecord addSkill(
            @RequestBody VolunteerSkillRecord skill) {
        return volunteerSkillService.addOrUpdateSkill(skill);
    }

    @GetMapping("/volunteer/{volunteerId}")
    public List<VolunteerSkillRecord> getSkills(
            @PathVariable Long volunteerId) {
        return volunteerSkillService.getSkillsByVolunteer(volunteerId);
    }
}
