package org.pragadeesh.fitnesstracker.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class WorkoutReportsDto {

    private LocalDate startDate;
    private LocalDate endDate;
    private Float completionRate;
}
