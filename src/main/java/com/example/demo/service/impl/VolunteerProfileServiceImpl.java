// package com.example.demo.service.impl;

// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.VolunteerProfile;
// import com.example.demo.repository.VolunteerProfileRepository;
// import com.example.demo.service.VolunteerProfileService;
// import org.springframework.stereotype.Service;
// import java.util.List;
// import java.util.Optional;
// @Service
// public class VolunteerProfileServiceImpl implements VolunteerProfileService {

//     private final VolunteerProfileRepository repository;

//     public VolunteerProfileServiceImpl(VolunteerProfileRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public VolunteerProfile createVolunteer(VolunteerProfile profile) {

//         if (repository.existsByVolunteerId(profile.getVolunteerId()))
//             throw new BadRequestException("VolunteerId already exists");

//         if (repository.existsByEmail(profile.getEmail()))
//             throw new BadRequestException("Email already exists");

//         if (repository.existsByPhone(profile.getPhone()))
//             throw new BadRequestException("Phone already exists");

//         return repository.save(profile);
//     }

//     @Override
//     public VolunteerProfile getVolunteerById(Long id) {
//         return repository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Volunteer not found"));
//     }

//     @Override
//     public List<VolunteerProfile> getAllVolunteers() {
//         return repository.findAll();
//     }

//     @Override
//     public Optional<VolunteerProfile> findByVolunteerId(String volunteerId) {
//         return repository.findByVolunteerId(volunteerId);
//     }

//     @Override
//     public VolunteerProfile updateAvailability(Long id, String availabilityStatus) {
//         VolunteerProfile v = getVolunteerById(id);
//         v.setAvailabilityStatus(availabilityStatus);
//         return repository.save(v);
//     }
// }


package com.example.demo.service.impl;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class VolunteerProfileServiceImpl implements VolunteerProfileService {
private final VolunteerProfileRepository repository;
public VolunteerProfileServiceImpl(VolunteerProfileRepository repository) {
this.repository = repository;
}
@Override
public VolunteerProfile registerVolunteer(RegisterRequest request) {
VolunteerProfile profile = new VolunteerProfile(
request.getName(),
request.getEmail(),
request.getAvailabilityStatus() != null ? request.getAvailabilityStatus() : "AVAILABLE"
);
return repository.save(profile);
}
@Override
public VolunteerProfile createVolunteer(VolunteerProfile profile) {
if (repository.existsByVolunteerId(profile.getVolunteerId())) {
throw new BadRequestException("Volunteer ID already exists");
}
if (repository.existsByEmail(profile.getEmail())) {
throw new BadRequestException("Email already exists");
}
if (repository.existsByPhone(profile.getPhone())) {
throw new BadRequestException("Phone already exists");
}
return repository.save(profile);
}
@Override
public VolunteerProfile getVolunteerById(Long id) {
return repository.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("Volunteer not found"));
}
@Override
public List<VolunteerProfile> getAllVolunteers() {
return repository.findAll();
}
@Override
public Optional<VolunteerProfile> findByVolunteerId(String volunteerId) {
return repository.findByVolunteerId(volunteerId);
}
@Override
public VolunteerProfile updateAvailability(Long volunteerId, String availabilityStatus) {
VolunteerProfile profile = repository.findById(volunteerId)
.orElseThrow(() -> new ResourceNotFoundException("Volunteer not found"));
profile.setAvailabilityStatus(availabilityStatus);
return repository.save(profile);
}
@Override
public List<VolunteerProfile> getAvailableVolunteers() {
return repository.findByAvailabilityStatus("AVAILABLE");
}
}
