package com.it.ballitchampionship.repository;

import com.it.ballitchampionship.entity.ChampionshipEntity;
import com.it.ballitchampionship.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionshipRepository extends JpaRepository<ChampionshipEntity, Long> {

}
