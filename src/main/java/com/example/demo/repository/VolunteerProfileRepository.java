// package com.example.demo.repository;

// import com.example.demo.model.VolunteerProfile;
// import java.util.List;
// import java.util.Optional;

// public interface VolunteerProfileRepository {

//     boolean existsByVolunteerId(String volunteerId);

//     boolean existsByEmail(String email);

//     boolean existsByPhone(String phone);

//     VolunteerProfile save(VolunteerProfile profile);

//     Optional<VolunteerProfile> findById(Long id);

//     Optional<VolunteerProfile> findByVolunteerId(String volunteerId);

//     List<VolunteerProfile> findAll();

//     List<VolunteerProfile> findByAvailabilityStatus(String status);
// }
package com.example.demo.repository;

import com.example.demo.model.VolunteerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VolunteerProfileRepository
        extends JpaRepository<VolunteerProfile, Long> {

    boolean existsByVolunteerId(String volunteerId);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    Optional<VolunteerProfile> findByVolunteerId(String volunteerId);

    List<VolunteerProfile> findByAvailabilityStatus(String status);
}
