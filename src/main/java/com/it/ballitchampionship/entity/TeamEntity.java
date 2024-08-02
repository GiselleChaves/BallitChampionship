package com.it.ballitchampionship.entity;

import com.it.ballitchampionship.entity.dtos.TeamDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "TB_TEAM")
@Entity
public class TeamEntity {

    public TeamEntity(TeamDto teamDto){
        this.name = teamDto.getName();
        this.warCry = teamDto.getWarCry();
        this.foundationYear = teamDto.getFoundationYear();
    }

    /*
     * The id is generated and incremented in the database in a sequencial form
     * id start in 1 (the first bet created)
     * Is the id column of the table
    */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    /*
     * The String "name" will store the team´s name
     * The column can´t be null
    */
    @Column(name = "name", nullable = false)
    private String name;

    /*
     * The String "war cry" will store the team´s war cry
     * The column can´t be null
     */
    @Column(name = "war_cry", nullable = false)
    private String warCry;

    /*
     * The String "foundation year" will store the team´s foundation year
     * The column can´t be null
     */
    @Column(name = "foundation_year", nullable = false)
    private String foundationYear;

    @Column(name = "blots_counter")
    private int blotsCounter;

    @Column(name = "plifs_counter")
    private int plifs_counter;

    @Column(name = "advrungh_counter")
    private int advrughCounter;

    @Column(name = "point_counter")
    private int pointCounter;

    @Column(name = "championship")
    private int championship;

    @ManyToOne
    @JoinTable(name = "championship_id")
    private ChampionshipEntity championshipEntity;

    @ManyToMany
    @JoinTable(
            name = "team_phase",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "phase_id")
    )
    private List<PhaseEntity> phases;

    @ManyToMany
    @JoinTable(
            name = "team_match",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "match_id")
    )
    private List<MatchEntity> matches;

}
