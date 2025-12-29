// package com.example.demo.service;

// import com.example.demo.model.VolunteerProfile;

// import java.util.List;
// import java.util.Optional;

// public interface VolunteerProfileService {

//     VolunteerProfile createVolunteer(VolunteerProfile profile);

//     VolunteerProfile getVolunteerById(Long id);

//     List<VolunteerProfile> getAllVolunteers();

//     Optional<VolunteerProfile> findByVolunteerId(String volunteerId);

//     VolunteerProfile updateAvailability(Long id, String availabilityStatus);
// }


package com.example.demo.service;

import com.example.demo.model.VolunteerProfile;
import java.util.List;

public interface VolunteerProfileService {

    VolunteerProfile createVolunteerProfile(VolunteerProfile volunteerProfile);

    VolunteerProfile getVolunteerProfileById(Long id);

    List<VolunteerProfile> getAllVolunteerProfiles();

    VolunteerProfile updateVolunteerProfile(Long id, VolunteerProfile volunteerProfile);

    void deleteVolunteerProfile(Long id);
}
