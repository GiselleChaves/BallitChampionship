package com.it.ballitchampionship.service;

import com.it.ballitchampionship.entity.ChampionshipEntity;
import com.it.ballitchampionship.entity.PhaseEntity;
import com.it.ballitchampionship.entity.TeamEntity;
import com.it.ballitchampionship.repository.ChampionshipRepository;
import com.it.ballitchampionship.repository.PhaseRepository;
import com.it.ballitchampionship.repository.TeamRepository;
import net.bytebuddy.implementation.bytecode.Throw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PhaseService {

    private List<TeamEntity> doublesPhase;
    private final TeamRepository teamRepository;
    private final PhaseRepository phaseRepository;
    private final ChampionshipService championshipService;
    private final ChampionshipRepository championshipRepository;

    public PhaseService(List<TeamEntity> doublesPhase, TeamRepository teamRepository, PhaseRepository phaseRepository, ChampionshipService championshipService, ChampionshipRepository championshipRepository) {
        this.teamRepository = teamRepository;
        this.phaseRepository = phaseRepository;
        this.championshipService = championshipService;
        this.championshipRepository = championshipRepository;
        this.doublesPhase = new ArrayList<>();
    }

    public List<TeamEntity> drawDoubles(Long championshipId){


        //CRIA UM ARRAY PARA ARMAZENAR OS ARRAYS DE PARES - FORA DO FOR
        List<TeamEntity> pairs = new ArrayList<>();

        //SE NÃO TEM QUANTIDADE CORRETA DE TIMES
        if(!championshipService.isCorrectTeamsNumber(championshipId)){
            return null;
        } else{
            List<TeamEntity> teams = championshipService.getTeams(championshipId);
            //EMBARALHA
            Collections.shuffle(teams);
            //SORTEIA
            for(int i=0; i<teams.size(); i+=2) {
                //CRIA UM ARRY PARA CADA PAR - DENTRO DO FOR
                List<TeamEntity> pair = new ArrayList<>();
                pair.add(teams.get(i));
                pair.add(teams.get(i+1));
                pairs.add((TeamEntity) pair);
            }
        }
        return pairs;
    }

//    public boolean startPhase(Long championshipId) {
//        this.drawDoubles()
//            PhaseEntity phaseEntity = new PhaseEntity();
//            phaseRepository.save(phaseEntity);
//            return true;
//        }
//    }
}
