package org.pragadeesh.fitnesstracker.model;

import jakarta.annotation.Nullable;
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
public class WorkoutComments {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "workout_id",nullable = false)
    private Workout workout;

    @Column(nullable = false)
    private String comments;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;


}
