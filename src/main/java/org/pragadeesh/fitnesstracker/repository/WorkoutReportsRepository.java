package org.pragadeesh.fitnesstracker.repository;


import org.pragadeesh.fitnesstracker.model.User;
import org.pragadeesh.fitnesstracker.model.WorkoutReports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WorkoutReportsRepository extends JpaRepository<WorkoutReports, UUID>{

    List<WorkoutReports> findByUser(User user);

}
