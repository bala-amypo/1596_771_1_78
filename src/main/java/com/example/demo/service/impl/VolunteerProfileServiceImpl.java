package com.example.demo.service.impl;

import com.example.demo.model.VolunteerProfile;
import org.springframework.stereotype.Service;

@Service
public class VolunteerProfileServiceImpl {

    public Long getProfileId(VolunteerProfile profile) {
        // ✅ FIXED: use getId(), NOT getVolunteerId()
        return profile.getId();
    }
}
