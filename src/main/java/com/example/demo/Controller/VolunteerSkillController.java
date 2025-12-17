package com.example.demo.controller;


import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/skills")
@Tag(name = "Volunteer Skills")
public class VolunteerSkillRecord {

    @PostMapping
    public String addOrUpdateSkill(@RequestBody Object skill) {
        return "Skill added/updated";
    }

    @GetMapping("/volunteer/{volunteerId}")
    public String getSkillsByVolunteer(@PathVariable Long volunteerId) {
        return "Skills for volunteer " + volunteerId;
    }

    @GetMapping("/{id}")
    public String getSkill(@PathVariable Long id) {
        return "Get skill " + id;
    }

    @GetMapping
    public String listAllSkills() {
        return "List all skills";
    }
}
