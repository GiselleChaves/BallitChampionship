package com.it.ballitchampionship.repository;

import com.it.ballitchampionship.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
}
