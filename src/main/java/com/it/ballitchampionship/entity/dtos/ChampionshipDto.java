package com.it.ballitchampionship.entity.dtos;

import com.it.ballitchampionship.entity.TeamEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChampionshipDto {

    private Long id;
    private List<TeamEntity> teams;
}
