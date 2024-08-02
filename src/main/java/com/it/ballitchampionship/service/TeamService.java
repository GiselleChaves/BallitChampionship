package com.it.ballitchampionship.service;

import com.it.ballitchampionship.entity.ChampionshipEntity;
import com.it.ballitchampionship.entity.TeamEntity;
import com.it.ballitchampionship.entity.dtos.TeamDto;
import com.it.ballitchampionship.repository.TeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

public class TeamService {

    private TeamRepository teamRepository;
    private ModelMapper modelMapper;
    private ChampionshipEntity championshipEntity;

    public TeamDto save(TeamDto teamDto){
        TeamEntity teamEntity = modelMapper.map(teamDto, TeamEntity.class);
        teamRepository.save(teamEntity);
        return teamDto;
    }
}
