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

import com.example.demo.model.VolunteerSkill;

import java.util.List;
import java.util.Optional;

public interface VolunteerSkillService {
    VolunteerSkill saveSkill(VolunteerSkill skill);
    Optional<VolunteerSkill> getSkillById(Long id);
    List<VolunteerSkill> getAllSkills();
    void deleteSkill(Long id);
}
