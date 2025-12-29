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

    VolunteerProfile createVolunteer(VolunteerProfile volunteer);

    VolunteerProfile getVolunteerById(Long id);

    List<VolunteerProfile> getAllVolunteers();

    VolunteerProfile updateAvailability(Long id, String availability);

    VolunteerProfile findByVolunteerId(String volunteerId);
}
