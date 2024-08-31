package org.pragadeesh.fitnesstracker.repository;

import org.pragadeesh.fitnesstracker.model.Workout;
import org.pragadeesh.fitnesstracker.model.WorkoutComments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WorkoutCommentRepository extends JpaRepository<WorkoutComments, UUID> {

    List<WorkoutComments> findByWorkoutId(UUID workout_id);

}
