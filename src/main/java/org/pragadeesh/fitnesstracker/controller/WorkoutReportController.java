package org.pragadeesh.fitnesstracker.controller;

import org.pragadeesh.fitnesstracker.model.WorkoutReports;
import org.pragadeesh.fitnesstracker.service.WorkoutReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/workout/report")
public class WorkoutReportController {

    private final WorkoutReportService workoutReportService;

    @Autowired
    public WorkoutReportController(WorkoutReportService workoutReportService) {
        this.workoutReportService = workoutReportService;
    }

    @PostMapping("/generate")
    public ResponseEntity<WorkoutReports> generateReport(@RequestParam UUID userId,
                                                         @RequestParam String startDate,
                                                         @RequestParam String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        WorkoutReports reports = workoutReportService.generateReport(userId, start, end);
        return new ResponseEntity<>(reports, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<WorkoutReports>> getReports(@RequestParam UUID userId) {
        List<WorkoutReports> reports = workoutReportService.getReports(userId);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }
}
