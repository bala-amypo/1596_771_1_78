// package com.example.demo.repository;

// import com.example.demo.model.VolunteerSkillRecord;
// import java.util.List;

// public interface VolunteerSkillRecordRepository {

//     VolunteerSkillRecord save(VolunteerSkillRecord skill);

//     List<VolunteerSkillRecord> findByVolunteerId(Long volunteerId);

//     List<VolunteerSkillRecord> findBySkillName(String skillName);

//     List<VolunteerSkillRecord> findBySkillNameAndSkillLevel(
//             String skillName,
//             String skillLevel
//     );
// }
package com.example.demo.repository;

import com.example.demo.model.VolunteerSkillRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VolunteerSkillRecordRepository
        extends JpaRepository<VolunteerSkillRecord, Long> {

    List<VolunteerSkillRecord> findByVolunteerId(Long volunteerId);

    List<VolunteerSkillRecord> findBySkillName(String skillName);

    List<VolunteerSkillRecord> findBySkillNameAndSkillLevel(
            String skillName,
            String skillLevel
    );
}
