package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "task_assignment")
public record TaskAssignmentRecord(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,

        @Column(nullable = false)
        Long taskId,

        @Column(nullable = false)
        Long userId,

        @Column(nullable = false)
        String status

) {
}
