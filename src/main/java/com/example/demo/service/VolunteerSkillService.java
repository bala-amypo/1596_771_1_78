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
public interface VolunteerSkillService {
List<VolunteerSkillRecord> getSkillsByVolunteer(Long volunteerId);
VolunteerSkillRecord addOrUpdateSkill(VolunteerSkillRecord skill);
}