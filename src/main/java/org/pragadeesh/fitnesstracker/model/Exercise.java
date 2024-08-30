package org.pragadeesh.fitnesstracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "workout_id", nullable = false)
    private Workout workout;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer reps;

    @Column(nullable = false)
    private Integer sets;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;


}
