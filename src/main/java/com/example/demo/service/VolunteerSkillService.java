public interface VolunteerSkillService {

    VolunteerSkillRecord addOrUpdateSkill(VolunteerSkillRecord skill);

    VolunteerSkillRecord getSkillById(Long id);

    List<VolunteerSkillRecord> getSkillsByVolunteer(Long volunteerId);

    List<VolunteerSkillRecord> getAllSkills();
}
