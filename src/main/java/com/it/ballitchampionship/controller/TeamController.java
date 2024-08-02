package com.it.ballitchampionship.controller;

import com.it.ballitchampionship.entity.dtos.TeamDto;
import com.it.ballitchampionship.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    private TeamService teamService;

    @PostMapping("/team")
    public ResponseEntity<TeamDto> save(@RequestBody TeamDto teamDto){
        teamService.save(teamDto);
        return new ResponseEntity<>(teamDto, HttpStatus.CREATED);
    }
}
