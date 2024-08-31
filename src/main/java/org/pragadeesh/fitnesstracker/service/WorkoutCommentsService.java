package org.pragadeesh.fitnesstracker.service;

import jakarta.persistence.EntityNotFoundException;
import org.pragadeesh.fitnesstracker.dto.WorkoutCommentsDto;
import org.pragadeesh.fitnesstracker.model.Workout;
import org.pragadeesh.fitnesstracker.model.WorkoutComments;
import org.pragadeesh.fitnesstracker.repository.WorkoutCommentRepository;
import org.pragadeesh.fitnesstracker.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class WorkoutCommentsService {

    private final WorkoutRepository workoutRepository;
    private final WorkoutCommentRepository workoutCommentRepository;

    @Autowired
    public WorkoutCommentsService(WorkoutRepository workoutRepository, WorkoutCommentRepository workoutCommentRepository) {
        this.workoutRepository = workoutRepository;
        this.workoutCommentRepository = workoutCommentRepository;
    }

    public WorkoutComments addCommentToWorkout(UUID workoutId, WorkoutCommentsDto workoutCommentsDto) {
        Workout workout = workoutRepository.findById(workoutId)
                .orElseThrow(() -> new EntityNotFoundException("Workout not found with Id " + workoutId));

        WorkoutComments comment = new WorkoutComments();
        comment.setComments(workoutCommentsDto.getComments());
        comment.setWorkout(workout);

        comment.setCreatedAt(LocalDateTime.now());

        return workoutCommentRepository.save(comment);
    }

    public List<WorkoutComments> getCommentsForWorkout(UUID workoutId) {
        return workoutCommentRepository.findByWorkoutId(workoutId);
    }

    public WorkoutComments updateComment(UUID commentId, WorkoutCommentsDto workoutCommentsDto) {
        WorkoutComments workoutComments = workoutCommentRepository.findById(commentId)
                .orElseThrow(() -> new EntityNotFoundException("Comment not found"));

        workoutComments.setComments(workoutCommentsDto.getComments());

        return workoutCommentRepository.save(workoutComments);
    }

    public void deleteComment(UUID commentId) {
        workoutCommentRepository.deleteById(commentId);
    }
}
