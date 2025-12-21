package com.example.demo.service;

import com.example.demo.model.VolunteerProfile;
import java.util.List;

public interface VolunteerProfileService {

    VolunteerProfile createVolunteer(VolunteerProfile profile);
    VolunteerProfile getVolunteerById(Long id);
    VolunteerProfile findByVolunteerId(String volunteerId);
    List<VolunteerProfile> getAllVolunteers();
    VolunteerProfile updateAvailability(Long id, String status);
}
