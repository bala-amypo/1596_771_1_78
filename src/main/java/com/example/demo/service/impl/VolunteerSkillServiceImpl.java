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

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import com.example.demo.service.VolunteerSkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // Automatically injects the repository
public class VolunteerSkillServiceImpl implements VolunteerSkillService {

    private final VolunteerSkillRecordRepository repository;

    @Override
    public VolunteerSkillRecord save(VolunteerSkillRecord skill) {
        return repository.save(skill);
    }

    @Override
    public Optional<VolunteerSkillRecord> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<VolunteerSkillRecord> getAllSkills() {
        return repository.findAll();
    }

    @Override
    public List<VolunteerSkillRecord> getSkillsByVolunteer(Long volunteerId) {
        return repository.findByVolunteerProfileId(volunteerId);
    }
}