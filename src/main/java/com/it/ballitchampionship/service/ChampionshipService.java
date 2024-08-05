package com.it.ballitchampionship.service;

import com.it.ballitchampionship.entity.ChampionshipEntity;
import com.it.ballitchampionship.entity.TeamEntity;
import com.it.ballitchampionship.entity.dtos.ChampionshipDto;
import com.it.ballitchampionship.entity.dtos.TeamDto;
import com.it.ballitchampionship.repository.ChampionshipRepository;
import com.it.ballitchampionship.repository.TeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChampionshipService {

    private final ChampionshipRepository championshipRepository;
    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;


    private ChampionshipService(ChampionshipRepository championshipRepository, TeamRepository teamRepository,
                                ModelMapper modelMapper){
        this.championshipRepository = championshipRepository;
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;
    }

    public ChampionshipDto findChampionship(Long championshipId) {
        Optional<ChampionshipEntity> championFound = championshipRepository.findById(championshipId);
        ChampionshipDto championshipDto = null;
        if (championFound.isPresent()) {
            championshipDto = modelMapper.map(championFound.get(), ChampionshipDto.class);
        }
        return championshipDto;
    }

    public boolean isCorrectTeamsNumber(Long championshipId){
        long countTeams = 0;
        ChampionshipDto championshipDto = findChampionship(championshipId);
        if(championshipDto != null){
            countTeams = championshipDto.getTeams().size();
        }
        return (countTeams > 1) && (countTeams < 4) && (countTeams % 2 != 0);
    }

    public boolean startChampionship(Long championshipId) {
        if(!isCorrectTeamsNumber(championshipId)) {
            return false;
        } else {
            ChampionshipEntity championshipEntity = new ChampionshipEntity();
            championshipRepository.save(championshipEntity);
            return true;
        }
    }


    public void addTeamToList(TeamDto teamDto){
        Optional<ChampionshipEntity> championFound = championshipRepository.findById(teamDto.getChampionshipId());
        if (championFound.isPresent()) {
            ChampionshipEntity championship = championFound.get();
            TeamEntity teamEntity = modelMapper.map(teamDto, TeamEntity.class);
            championship.getTeams().add(teamEntity);
            teamEntity.setChampionship(championship);
            championshipRepository.save(championship);
            System.out.println("Adicionado");
        }
        System.out.println("ERRO");
    }

    public void deleteTeamToList(TeamDto teamDto){
        Optional<ChampionshipEntity> championFound = championshipRepository.findById(Long.valueOf(teamDto.getChampionshipId()));
        if (championFound.isPresent()) {
            ChampionshipEntity championship = championFound.get();
            TeamEntity teamEntity = modelMapper.map(teamDto, TeamEntity.class);
            championship.getTeams().remove(teamEntity);
            teamEntity.setChampionship(championship);
            championshipRepository.save(championship);
        }
    }

    public List<TeamEntity> getTeams(Long championshipId){
        Optional<ChampionshipEntity> championshipFound = championshipRepository.findById(championshipId);
        return championshipFound.map(ChampionshipEntity::getTeams).orElse(null);
    }

}
