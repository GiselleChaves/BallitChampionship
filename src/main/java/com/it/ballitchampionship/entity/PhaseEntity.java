package com.it.ballitchampionship.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_PHASE")
public class PhaseEntity {

    /*
     * The id is generated and incremented in the database in a sequencial form
     * id start in 1 (the first bet created)
     * Is the id column of the table
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @ManyToMany
    private List<ChampionshipEntity> championships = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "phases_matches",
            joinColumns = @JoinColumn(name = "phase_id"),
            inverseJoinColumns = @JoinColumn(name = "match_id")
    )
    private List<MatchEntity> matches;


    @ManyToMany
    @JoinTable(
            name = "phases_teams",
            joinColumns = @JoinColumn(name = "phase_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private List<TeamEntity> teams;
}
