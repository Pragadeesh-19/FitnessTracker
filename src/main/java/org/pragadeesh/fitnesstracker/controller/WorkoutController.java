package org.pragadeesh.fitnesstracker.controller;

import org.pragadeesh.fitnesstracker.dto.WorkoutDto;
import org.pragadeesh.fitnesstracker.model.Workout;
import org.pragadeesh.fitnesstracker.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/workout")
public class WorkoutController {

    private final WorkoutService workoutService;

    @Autowired
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping
    public ResponseEntity<List<Workout>> getAllWorkouts(UUID userId) {
        return new ResponseEntity<>(workoutService.getAllWorkouts(userId), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Workout> createWorkout(@RequestParam UUID userId,
                                                 @RequestBody WorkoutDto workoutDto) {
        return new ResponseEntity<>(workoutService.createWorkout(workoutDto, userId), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Workout> updateWorkout(@PathVariable UUID id,
                                                 @RequestBody WorkoutDto workoutDto) {
        return new ResponseEntity<>(workoutService.updateWorkout(id, workoutDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMapping(@PathVariable UUID id) {
        workoutService.deleteWorkout(id);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<Workout> changeWorkoutStatus(@PathVariable UUID id) {
        return new ResponseEntity<>(workoutService.markWorkoutAsCompleted(id), HttpStatus.OK);
    }

}

