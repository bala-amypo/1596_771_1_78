package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.VolunteerProfile;

public interface VolunteerProfileRepository extends JpaRepository<VolunteerProfile, Long> {

    boolean existsByVolunteerId(String volunteerId);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    List<VolunteerProfile> findByAvailabilityStatus(String status);

    Optional<VolunteerProfile> findByVolunteerId(String volunteerId);
}
