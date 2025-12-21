package com.example.demo.controller;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class VolunteerSkillController {

    private final VolunteerSkillService service;

    public VolunteerSkillController(VolunteerSkillService service) {
        this.service = service;
    }

    @PostMapping
    public VolunteerSkillRecord add(@RequestBody VolunteerSkillRecord skill) {
        return service.addSkill(skill);
    }

    @GetMapping("/volunteer/{id}")
    public List<VolunteerSkillRecord> get(@PathVariable Long id) {
        return service.getSkillsByVolunteer(id);
    }
}
