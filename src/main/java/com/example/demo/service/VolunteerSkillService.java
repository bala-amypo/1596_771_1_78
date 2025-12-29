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
    VolunteerSkillRecord save(VolunteerSkillRecord skill);
    Optional<VolunteerSkillRecord> findById(Long id);
    List<VolunteerSkillRecord> getAllSkills();
    List<VolunteerSkillRecord> getSkillsByVolunteer(Long volunteerId);
}