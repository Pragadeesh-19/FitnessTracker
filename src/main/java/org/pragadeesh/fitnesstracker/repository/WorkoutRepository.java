package org.pragadeesh.fitnesstracker.repository;

import org.pragadeesh.fitnesstracker.model.Status;
import org.pragadeesh.fitnesstracker.model.Workout;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, UUID> {

    List<Workout> findByUserId(UUID user_id);

    long countByUserIdAndDateBetween(UUID userId, LocalDate startDate, LocalDate endDate);

    long countByUserIdAndStatusAndDateBetween(UUID userId, Status status, LocalDate startDate, LocalDate endDate);
}
