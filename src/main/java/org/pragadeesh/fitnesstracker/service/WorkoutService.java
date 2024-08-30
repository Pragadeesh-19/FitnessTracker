package org.pragadeesh.fitnesstracker.service;

import jakarta.persistence.EntityNotFoundException;
import org.pragadeesh.fitnesstracker.dto.WorkoutDto;
import org.pragadeesh.fitnesstracker.model.Status;
import org.pragadeesh.fitnesstracker.model.User;
import org.pragadeesh.fitnesstracker.model.Workout;
import org.pragadeesh.fitnesstracker.repository.UserRepository;
import org.pragadeesh.fitnesstracker.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;
    private final UserRepository userRepository;

    @Autowired
    public WorkoutService(WorkoutRepository workoutRepository,UserRepository userRepository) {
        this.workoutRepository = workoutRepository;
        this.userRepository = userRepository;
    }

    public Workout createWorkout(WorkoutDto workoutDto, UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found!!"));

        Workout workout = new Workout();
        workout.setName(workout.getName());
        workout.setDate(workoutDto.getDate());
        workout.setStatus(Status.PENDING);
        workout.setUser(user);

        workout.setCreatedAt(LocalDateTime.now());

        return workoutRepository.save(workout);
    }

    public List<Workout> getAllWorkouts(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found!!"));

        return workoutRepository.findByUserId(userId);
    }

    public Workout updateWorkout(UUID workoutId, WorkoutDto workoutDto) {
        Workout workout = workoutRepository.findById(workoutId)
                .orElseThrow(() -> new EntityNotFoundException("Workout not found!!"));

        workout.setName(workout.getName());
        workout.setDate(workoutDto.getDate());
        return workoutRepository.save(workout);
    }

    public void deleteWorkout(UUID workoutId) {
        workoutRepository.deleteById(workoutId);
    }

    public Workout markWorkoutAsCompleted(UUID workoutId) {
        Workout workout = workoutRepository.findById(workoutId)
                .orElseThrow(() -> new EntityNotFoundException("Workout not found!!"));

        workout.setStatus(Status.COMPLETED);
        return workoutRepository.save(workout);
    }
}
