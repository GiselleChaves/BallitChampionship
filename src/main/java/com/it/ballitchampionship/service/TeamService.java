package com.it.ballitchampionship.service;

import com.it.ballitchampionship.entity.TeamEntity;
import com.it.ballitchampionship.entity.dtos.TeamDto;
import com.it.ballitchampionship.repository.ChampionshipRepository;
import com.it.ballitchampionship.repository.TeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;


@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;
    private final ChampionshipService championshipService;

    private final ChampionshipRepository championshipRepository;

    //private List<TeamDto> teamsList;

    public TeamService(TeamRepository teamRepository, ModelMapper modelMapper, List<TeamDto> teamsList, ChampionshipService championshipService, ChampionshipRepository championshipRepository){
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;
        this.championshipService = championshipService;
        this.championshipRepository = championshipRepository;
        //this.teamsList = new ArrayList<>();
    }

    public TeamDto save(TeamDto teamDto){
        TeamEntity teamEntity = new TeamEntity();
        teamRepository.save(new TeamEntity(teamDto));
        championshipService.addTeamToList(teamDto);
        return teamDto;
    }
    public void delete(TeamDto teamDto){
        TeamEntity teamEntity = modelMapper.map(teamDto, TeamEntity.class);
        teamRepository.delete(teamEntity);
        championshipService.deleteTeamToList(teamDto);
    }
}
