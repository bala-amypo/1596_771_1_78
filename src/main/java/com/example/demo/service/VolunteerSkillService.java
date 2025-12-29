// package com.example.demo.service;

// import com.example.demo.model.VolunteerSkillRecord;

// import java.util.List;

// public interface VolunteerSkillService {

//     VolunteerSkillRecord addOrUpdateSkill(VolunteerSkillRecord skill);

//     List<VolunteerSkillRecord> getSkillsByVolunteer(Long volunteerId);

//     VolunteerSkillRecord getSkillById(Long id);

//     List<VolunteerSkillRecord> getAllSkills();
// }


package com.example.demo.service;

import com.example.demo.model.VolunteerSkillRecord;
import java.util.List;
import java.util.Optional;

public interface VolunteerSkillService {
    // Required for POST /
    VolunteerSkillRecord save(VolunteerSkillRecord skill);
    
    // Required for GET /{id}
    Optional<VolunteerSkillRecord> findById(Long id);

    // Required for GET /
    List<VolunteerSkillRecord> getAllSkills();

    // Required for GET /volunteer/{volunteerId}
    List<VolunteerSkillRecord> getSkillsByVolunteer(Long volunteerId);
}