package com.example.demo.service;

import com.example.demo.model.VolunteerProfile;

import java.util.List;

public interface VolunteerProfileService {

    VolunteerProfile createVolunteer(VolunteerProfile profile);

    VolunteerProfile getByVolunteerId(String volunteerId);

    List<VolunteerProfile> getAllVolunteers();
}
