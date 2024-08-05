package com.it.ballitchampionship.repository;

import com.it.ballitchampionship.entity.PhaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhaseRepository extends JpaRepository<PhaseEntity, Long> {
}
