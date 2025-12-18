package com.example.demo.repository;

import com.example.demo.model.VolunteerSkillRecord;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class VolunteerSkillRecordRepository {

    private final Map<Long, VolunteerSkillRecord> store = new HashMap<>();
    private long id = 1;

    public VolunteerSkillRecord save(VolunteerSkillRecord record) {
        record.setId(id++);
        store.put(record.getId(), record);
        return record;
    }

    public List<VolunteerSkillRecord> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<VolunteerSkillRecord> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public void deleteById(Long id) {
        store.remove(id);
    }

    public Optional<VolunteerSkillRecord> findByVolunteerId(Long volunteerId) {
        return store.values().stream()
                .filter(v -> v.getVolunteerId().equals(volunteerId))
                .findFirst();
    }
}
