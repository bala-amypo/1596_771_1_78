// package com.example.demo.service.impl;

// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.TaskAssignmentRecord;
// import com.example.demo.model.TaskRecord;
// import com.example.demo.model.VolunteerProfile;
// import com.example.demo.model.VolunteerSkillRecord;
// import com.example.demo.repository.TaskAssignmentRecordRepository;
// import com.example.demo.repository.TaskRecordRepository;
// import com.example.demo.repository.VolunteerProfileRepository;
// import com.example.demo.repository.VolunteerSkillRecordRepository;
// import com.example.demo.service.TaskAssignmentService;
// import com.example.demo.util.SkillLevelUtil;
// import org.springframework.stereotype.Service;

// import java.util.Comparator;
// import java.util.List;
// @Service
// public class TaskAssignmentServiceImpl implements TaskAssignmentService {

//     private final TaskAssignmentRecordRepository assignmentRepo;
//     private final TaskRecordRepository taskRepo;
//     private final VolunteerProfileRepository volunteerRepo;
//     private final VolunteerSkillRecordRepository skillRepo;

//     public TaskAssignmentServiceImpl(
//             TaskAssignmentRecordRepository assignmentRepo,
//             TaskRecordRepository taskRepo,
//             VolunteerProfileRepository volunteerRepo,
//             VolunteerSkillRecordRepository skillRepo) {

//         this.assignmentRepo = assignmentRepo;
//         this.taskRepo = taskRepo;
//         this.volunteerRepo = volunteerRepo;
//         this.skillRepo = skillRepo;
//     }

//     @Override
//     public TaskAssignmentRecord assignTask(Long taskId) {

//         TaskRecord task = taskRepo.findById(taskId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

//         if (assignmentRepo.existsByTaskIdAndStatus(taskId, "ACTIVE"))
//             throw new BadRequestException("ACTIVE assignment already exists");

//         List<VolunteerProfile> volunteers =
//                 volunteerRepo.findByAvailabilityStatus("AVAILABLE");

//         if (volunteers.isEmpty())
//             throw new BadRequestException("No AVAILABLE volunteers");

//         VolunteerProfile best = null;
//         int bestRank = 0;

//         for (VolunteerProfile v : volunteers) {
//             List<VolunteerSkillRecord> skills =
//                     skillRepo.findByVolunteerId(v.getId());

//             for (VolunteerSkillRecord s : skills) {
//                 if (s.getSkillName().equals(task.getRequiredSkill())) {
//                     int rank = SkillLevelUtil.levelRank(s.getSkillLevel());
//                     int required = SkillLevelUtil.levelRank(task.getRequiredSkillLevel());
//                     if (rank >= required && rank > bestRank) {
//                         best = v;
//                         bestRank = rank;
//                     }
//                 }
//             }
//         }

//         if (best == null)
//             throw new BadRequestException("required skill level");

//         TaskAssignmentRecord record = new TaskAssignmentRecord();
//         record.setTaskId(taskId);
//         record.setVolunteerId(best.getId());

//         TaskAssignmentRecord saved = assignmentRepo.save(record);
//         task.setStatus("ASSIGNED");
//         taskRepo.save(task);

//         return saved;
//     }

//     @Override
//     public TaskAssignmentRecord updateAssignmentStatus(Long id, String status) {
//         TaskAssignmentRecord rec = assignmentRepo.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Assignment not found"));
//         rec.setStatus(status);
//         return assignmentRepo.save(rec);
//     }

//     @Override
//     public List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId) {
//         return assignmentRepo.findByVolunteerId(volunteerId);
//     }

//     @Override
//     public List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId) {
//         return assignmentRepo.findByTaskId(taskId);
//     }

//     @Override
//     public List<TaskAssignmentRecord> getAllAssignments() {
//         return assignmentRepo.findAll();
//     }
// }



package com.example.demo.service.impl;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.model.TaskRecord;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import com.example.demo.service.TaskAssignmentService;
import com.example.demo.util.SkillLevelUtil;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {
private final TaskAssignmentRecordRepository assignmentRepository;
private final TaskRecordRepository taskRepository;
private final VolunteerProfileRepository volunteerRepository;
private final VolunteerSkillRecordRepository skillRepository;
public TaskAssignmentServiceImpl(TaskAssignmentRecordRepository assignmentRepository,
TaskRecordRepository taskRepository,
VolunteerProfileRepository volunteerRepository,
VolunteerSkillRecordRepository skillRepository) {
this.assignmentRepository = assignmentRepository;
this.taskRepository = taskRepository;
this.volunteerRepository = volunteerRepository;
this.skillRepository = skillRepository;
}
@Override
public TaskAssignmentRecord assignTask(Long taskId) {
if (assignmentRepository.existsByTaskIdAndStatus(taskId, "ACTIVE")) {
throw new BadRequestException("Task already has an ACTIVE assignment");
}
TaskRecord task = taskRepository.findById(taskId)
.orElseThrow(() -> new ResourceNotFoundException("Task not found"));
List<VolunteerProfile> availableVolunteers =
volunteerRepository.findByAvailabilityStatus("AVAILABLE");
if (availableVolunteers.isEmpty()) 
throw new BadRequestException("No AVAILABLE volunteers found");
}
for (VolunteerProfile volunteer : availableVolunteers) {
List<VolunteerSkillRecord> skills = skillRepository.findByVolunteerId(volunteer.getId());
for (VolunteerSkillRecord skill : skills) {
if (skill.getSkillName().equals(task.getRequiredSkill()) &&
SkillLevelUtil.isSkillLevelSufficient(skill.getSkillLevel(), task.getRequiredSkillLevel())) {
TaskAssignmentRecord assignment = new TaskAssignmentRecord(taskId,
volunteer.getId(), "ACTIVE");
assignment = assignmentRepository.save(assignment);
task.setStatus("ACTIVE");
taskRepository.save(task);
return assignment;
}
}
}
throw new BadRequestException("No volunteer with sufficient required skill level found");
}
@Override
public List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId) {
return assignmentRepository.findByTaskId(taskId);
}
@Override
public List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId) {
return assignmentRepository.findByVolunteerId(volunteerId);
}
@Override
public List<TaskAssignmentRecord> getAllAssignments() {
return assignmentRepository.findAll();
}
}