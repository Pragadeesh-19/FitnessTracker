package org.pragadeesh.fitnesstracker.dto;

import jakarta.annotation.Nonnull;
import lombok.Data;

@Data
public class ExerciseDto {
    private String name;
    private Integer reps;
    private Integer sets;
}
