package com.example.demo.controller;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class VolunteerSkillController {

    private final VolunteerSkillService service;

    public VolunteerSkillController(VolunteerSkillService service) {
        this.service = service;
    }

    @PostMapping
    public VolunteerSkillRecord addSkill(@RequestBody VolunteerSkillRecord record) {
        return service.addOrUpdateSkill(record);
    }

    @GetMapping("/volunteer/{id}")
    public List<VolunteerSkillRecord> getByVolunteer(@PathVariable Long id) {
        return service.getSkillsByVolunteer(id);
    }
}
