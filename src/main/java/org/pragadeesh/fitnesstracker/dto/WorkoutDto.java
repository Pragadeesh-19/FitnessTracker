package org.pragadeesh.fitnesstracker.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class WorkoutDto {

    private String name;
    private LocalDate date;
}
