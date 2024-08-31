package org.pragadeesh.fitnesstracker.controller;

import org.pragadeesh.fitnesstracker.dto.ExerciseDto;
import org.pragadeesh.fitnesstracker.model.Exercise;
import org.pragadeesh.fitnesstracker.service.ExerciseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping("/create")
    public ResponseEntity<Exercise> addExerciseToWorkout(@RequestParam UUID workoutId,
                                                         @RequestBody ExerciseDto exerciseDto) {
        return new ResponseEntity<>(exerciseService.addExerciseToWorkout(workoutId, exerciseDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Exercise> updateExercise(@RequestParam UUID exerciseId,
                                                   @RequestBody ExerciseDto exerciseDto) {
        return new ResponseEntity<>(exerciseService.updateExercise(exerciseId, exerciseDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteExercise(@RequestParam UUID exerciseId) {
        exerciseService.deleteExercise(exerciseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


