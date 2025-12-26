// // package com.example.demo.service.impl;

// // import com.example.demo.model.VolunteerSkillRecord;
// // import com.example.demo.repository.VolunteerSkillRecordRepository;
// // import com.example.demo.service.VolunteerSkillService;

// // import java.time.LocalDateTime;
// // import java.util.List;

// // public class VolunteerSkillServiceImpl implements VolunteerSkillService {

// //     private final VolunteerSkillRecordRepository repository;

// //     public VolunteerSkillServiceImpl(VolunteerSkillRecordRepository repository) {
// //         this.repository = repository;
// //     }

// //     @Override
// //     public VolunteerSkillRecord addOrUpdateSkill(VolunteerSkillRecord skill) {
// //         skill.setUpdatedAt(LocalDateTime.now());
// //         return repository.save(skill);
// //     }

// //     @Override
// //     public List<VolunteerSkillRecord> getSkillsByVolunteer(Long volunteerId) {
// //         return repository.findByVolunteerId(volunteerId);
// //     }
// // }

// package com.example.demo.service.impl;

// import com.example.demo.model.VolunteerSkillRecord;
// import com.example.demo.repository.VolunteerSkillRecordRepository;
// import com.example.demo.service.VolunteerSkillService;
// import org.springframework.stereotype.Service; // <--- Add this import

// import java.time.LocalDateTime;
// import java.util.List;

// @Service // <--- ADD THIS ANNOTATION HERE
// public class VolunteerSkillServiceImpl implements VolunteerSkillService {

//     private final VolunteerSkillRecordRepository repository;

//     // Spring uses this constructor to inject the repository automatically
//     public VolunteerSkillServiceImpl(VolunteerSkillRecordRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public VolunteerSkillRecord addOrUpdateSkill(VolunteerSkillRecord skill) {
//         skill.setUpdatedAt(LocalDateTime.now());
//         return repository.save(skill);
//     }

//     @Override
//     public List<VolunteerSkillRecord> getSkillsByVolunteer(Long volunteerId) {
//         return repository.findByVolunteerId(volunteerId);
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.VolunteerSkillRecordRepository; // Updated import
import com.example.demo.service.VolunteerSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VolunteerSkillServiceImpl implements VolunteerSkillService {

    @Autowired
    private VolunteerSkillRecordRepository volunteerSkillRecordRepository; // Updated variable

    @Override
    public VolunteerSkillRecord addOrUpdateSkill(VolunteerSkillRecord skill) {
        return volunteerSkillRecordRepository.save(skill);
    }

    @Override
    public List<VolunteerSkillRecord> getSkillsByVolunteer(Long volunteerId) {
        return volunteerSkillRecordRepository.findByVolunteerId(volunteerId);
    }

    @Override
    public VolunteerSkillRecord getSkillById(Long id) {
        return volunteerSkillRecordRepository.findById(id).orElse(null);
    }

    @Override
    public List<VolunteerSkillRecord> getAllSkills() {
        return volunteerSkillRecordRepository.findAll();
    }
}