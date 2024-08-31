package org.pragadeesh.fitnesstracker.service;

import jakarta.persistence.EntityNotFoundException;
import org.pragadeesh.fitnesstracker.dto.ExerciseDto;
import org.pragadeesh.fitnesstracker.model.Exercise;
import org.pragadeesh.fitnesstracker.model.Workout;
import org.pragadeesh.fitnesstracker.repository.ExerciseRepository;
import org.pragadeesh.fitnesstracker.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final WorkoutRepository workoutRepository;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository, WorkoutRepository workoutRepository) {
        this.exerciseRepository = exerciseRepository;
        this.workoutRepository = workoutRepository;
    }

    public Exercise addExerciseToWorkout(UUID workoutId, ExerciseDto exerciseDto) {
        Workout existingWorkout = workoutRepository.findById(workoutId)
                .orElseThrow(() -> new EntityNotFoundException("Workout not found with workoutId " + workoutId));

        Exercise exercise = new Exercise();
        exercise.setName(exerciseDto.getName());
        exercise.setReps(exerciseDto.getReps());
        exercise.setSets(exerciseDto.getSets());
        exercise.setWorkout(existingWorkout);

        exercise.setCreatedAt(LocalDateTime.now());

        return exerciseRepository.save(exercise);
    }

    public Exercise updateExercise(UUID exerciseId, ExerciseDto exerciseDto) {
        Exercise exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new EntityNotFoundException("Exercise not found with id " + exerciseId));

        exercise.setName(exercise.getName());
        exercise.setReps(exerciseDto.getReps());
        exercise.setSets(exerciseDto.getSets());

        return exerciseRepository.save(exercise);
    }

    public void deleteExercise(UUID exerciseId) {
        exerciseRepository.deleteById(exerciseId);
    }
}
