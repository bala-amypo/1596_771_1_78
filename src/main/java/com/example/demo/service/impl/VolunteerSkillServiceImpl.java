// package com.example.demo.service.impl;

// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.VolunteerSkillRecord;
// import com.example.demo.repository.VolunteerSkillRecordRepository;
// import com.example.demo.service.VolunteerSkillService;
// import org.springframework.stereotype.Service;
// import java.util.List;
// @Service
// public class VolunteerSkillServiceImpl implements VolunteerSkillService {

//     private final VolunteerSkillRecordRepository repository;

//     public VolunteerSkillServiceImpl(VolunteerSkillRecordRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public VolunteerSkillRecord addOrUpdateSkill(VolunteerSkillRecord skill) {
//         return repository.save(skill);
//     }

//     @Override
//     public List<VolunteerSkillRecord> getSkillsByVolunteer(Long volunteerId) {
//         return repository.findByVolunteerId(volunteerId);
//     }

//     @Override
//     public VolunteerSkillRecord getSkillById(Long id) {
//         return repository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Skill not found"));
//     }

//     @Override
//     public List<VolunteerSkillRecord> getAllSkills() {
//         return repository.findAll();
//     }
// }


package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.VolunteerSkill;
import com.example.demo.repository.VolunteerSkillRepository;
import com.example.demo.service.VolunteerSkillService;

import java.util.List;
import java.util.Optional;

@Service
public class VolunteerSkillServiceImpl implements VolunteerSkillService {

    @Autowired
    private VolunteerSkillRepository volunteerSkillRepository;

    @Override
    public VolunteerSkill saveSkill(VolunteerSkill skill) {
        return volunteerSkillRepository.save(skill);
    }

    @Override
    public Optional<VolunteerSkill> getSkillById(Long id) {
        return volunteerSkillRepository.findById(id);
    }

    @Override
    public List<VolunteerSkill> getAllSkills() {
        return volunteerSkillRepository.findAll();
    }

    @Override
    public void deleteSkill(Long id) {
        volunteerSkillRepository.deleteById(id);
    }
}
