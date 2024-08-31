package org.pragadeesh.fitnesstracker.controller;

import org.pragadeesh.fitnesstracker.dto.WorkoutCommentsDto;
import org.pragadeesh.fitnesstracker.model.WorkoutComments;
import org.pragadeesh.fitnesstracker.service.WorkoutCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/workout")
public class WorkoutCommentController {

    private final WorkoutCommentsService workoutCommentsService;

    @Autowired
    public WorkoutCommentController(WorkoutCommentsService workoutCommentsService) {
        this.workoutCommentsService = workoutCommentsService;
    }

    @PostMapping("/{workoutId}/comments")
    public ResponseEntity<WorkoutComments> addCommentToWorkout(@PathVariable UUID workoutId,
                                                               @RequestBody WorkoutCommentsDto workoutCommentsDto) {
        return new ResponseEntity<>(workoutCommentsService.addCommentToWorkout(workoutId, workoutCommentsDto), HttpStatus.CREATED);
    }

    @GetMapping("/{workoutId}/comments")
    public ResponseEntity<List<WorkoutComments>> getCommentsForWorkout(@PathVariable UUID workoutId) {
        return new ResponseEntity<>(workoutCommentsService.getCommentsForWorkout(workoutId), HttpStatus.OK);
    }

    @PutMapping("/comments/{commentId}")
    public ResponseEntity<WorkoutComments> updateComment(@PathVariable UUID commentId,
                                                         @RequestBody WorkoutCommentsDto workoutCommentsDto) {
        return new ResponseEntity<>(workoutCommentsService.updateComment(commentId, workoutCommentsDto), HttpStatus.OK);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable UUID commentId) {
        workoutCommentsService.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
