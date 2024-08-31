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
    public ResponseEntity<List<Workout>> getAllWorkouts(@RequestParam UUID userId) {
        return new ResponseEntity<>(workoutService.getAllWorkouts(userId), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Workout> createWorkout(@RequestParam UUID userId,
                                                 @RequestBody WorkoutDto workoutDto) {
        return new ResponseEntity<>(workoutService.createWorkout(userId, workoutDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{workoutId}")
    public ResponseEntity<Workout> updateWorkout(@PathVariable UUID workoutId,
                                                 @RequestBody WorkoutDto workoutDto) {
        return new ResponseEntity<>(workoutService.updateWorkout(workoutId, workoutDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{workoutId}")
    public void deleteMapping(@PathVariable UUID workoutId) {
        workoutService.deleteWorkout(workoutId);
    }

    @PutMapping("/status/{workoutId}")
    public ResponseEntity<Workout> changeWorkoutStatus(@PathVariable UUID workoutId) {
        return new ResponseEntity<>(workoutService.markWorkoutAsCompleted(workoutId), HttpStatus.OK);
    }

}

