package org.pragadeesh.fitnesstracker.repository;

import org.pragadeesh.fitnesstracker.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, UUID> {

    List<Exercise> findByWorkoutId(UUID workoutId);

}
