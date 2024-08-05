package com.it.ballitchampionship.controller;

import com.it.ballitchampionship.entity.TeamEntity;
import com.it.ballitchampionship.entity.dtos.TeamDto;
import com.it.ballitchampionship.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;


@RestController()
@RequestMapping("api/teams")
public class TeamController {


    private final TeamService teamService;

    public TeamController(TeamService teamService){
        this.teamService = teamService;
    }

    @PostMapping(value = "/team")
    public ResponseEntity<?> save(@RequestBody TeamDto teamDto) {
        try {
            teamService.save(teamDto);
            return new ResponseEntity<>(teamDto, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Não foi possível salvar time ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleException(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    @DeleteMapping(value = "/team")
    public ResponseEntity<?> delete(@RequestBody TeamDto teamDto) {
        try {
            teamService.delete(teamDto);
            return new ResponseEntity<>(teamDto, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Não foi possível localizar time ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
