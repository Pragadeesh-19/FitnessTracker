package org.pragadeesh.fitnesstracker.service;

import jakarta.persistence.EntityNotFoundException;
import org.pragadeesh.fitnesstracker.model.Status;
import org.pragadeesh.fitnesstracker.model.User;
import org.pragadeesh.fitnesstracker.model.WorkoutReports;
import org.pragadeesh.fitnesstracker.repository.UserRepository;
import org.pragadeesh.fitnesstracker.repository.WorkoutReportsRepository;
import org.pragadeesh.fitnesstracker.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class WorkoutReportService {

    private final WorkoutRepository workoutRepository;
    private final WorkoutReportsRepository workoutReportsRepository;
    private final UserRepository userRepository;

    @Autowired
    public WorkoutReportService(WorkoutRepository workoutRepository, WorkoutReportsRepository workoutReportsRepository, UserRepository userRepository) {
        this.workoutRepository = workoutRepository;
        this.workoutReportsRepository = workoutReportsRepository;
        this.userRepository = userRepository;
    }

    public WorkoutReports generateReport(UUID userId, LocalDate startDate, LocalDate endDate) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with userId " + userId));

        long totalWorkouts = workoutRepository.countByUserIdAndDateBetween(userId, startDate, endDate);
        long completedWorkouts = workoutRepository.countByUserIdAndStatusAndDateBetween(userId, Status.COMPLETED, startDate, endDate);

        WorkoutReports reports = new WorkoutReports();
        reports.setUser(user);
        reports.setStartDate(startDate);
        reports.setEndDate(endDate);

        if (totalWorkouts > 0) {
            reports.setCompletionRate((float) completedWorkouts / totalWorkouts);
        } else {
            reports.setCompletionRate((float)0);  // Set to 0 if no workouts were planned
        }

        return workoutReportsRepository.save(reports);
    }

    public List<WorkoutReports> getReports(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with userId " + userId));

        return workoutReportsRepository.findByUser(user);
    }
}
