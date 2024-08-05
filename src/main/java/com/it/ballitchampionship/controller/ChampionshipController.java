package com.it.ballitchampionship.controller;

import com.it.ballitchampionship.service.ChampionshipService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/champioship")
public class ChampionshipController {

    private final ChampionshipService championshipService;

    public ChampionshipController(ChampionshipService championshipService) {
        this.championshipService = championshipService;
    }


    @PostMapping("/start")
    public ResponseEntity<String> startChampionship(Long championshipId) {
        boolean isStarted = championshipService.startChampionship(championshipId);
        if (isStarted) {
            return new ResponseEntity<>("Campeonato iniciado com sucesso", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Não foi possível iniciar o campeonato", HttpStatus.BAD_REQUEST);
        }
    }
}