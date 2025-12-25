package com.example.demo.service;

import com.example.demo.model.VolunteerProfile;
import java.util.*;

public interface VolunteerProfileService {
    VolunteerProfile createVolunteer(VolunteerProfile v);
    VolunteerProfile getVolunteerById(Long id);
    List<VolunteerProfile> getAllVolunteers();
    Optional<VolunteerProfile> findByVolunteerId(String id);
}
