package com.example.demo.Controller;

import com.example.demo.model.VolunteerSkill;
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
    public VolunteerSkill createVolunteerSkill(@RequestBody VolunteerSkill skill) {
        return volunteerSkillService.save(skill);
    }

    @GetMapping
    public List<VolunteerSkill> getAllVolunteerSkills() {
        return volunteerSkillService.getAll();
    }

    @GetMapping("/{id}")
    public VolunteerSkill getVolunteerSkillById(@PathVariable Long id) {
        return volunteerSkillService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteVolunteerSkill(@PathVariable Long id) {
        volunteerSkillService.delete(id);
    }
}
