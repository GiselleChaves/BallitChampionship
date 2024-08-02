package com.it.ballitchampionship.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_CHAMPIONSHIP")
public class ChampionshipEntity {

    /*
     * The id is generated and incremented in the database in a sequencial form
     * id start in 1 (the first champioship created)
     * Is the id column of the table
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @ManyToMany
    @JoinTable(
            name = "championships_teams",
            joinColumns = @JoinColumn(name = "championship_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    List<TeamEntity> teams;


    @ManyToMany
    @JoinTable(
            name = "championships_phases",
            joinColumns = @JoinColumn(name = "championship_id"),
            inverseJoinColumns = @JoinColumn(name = "phase_id")
    )
    List<PhaseEntity> phases;
}
