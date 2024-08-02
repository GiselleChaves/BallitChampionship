package com.it.ballitchampionship.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_MATCH")
public class MatchEntity {

    /*
     * The id is generated and incremented in the database in a sequencial form
     * id start in 1 (the first bet created)
     * Is the id column of the table
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    /*
     * The Boolean "isActive" shows if the match is the current active
     * the column can´t be null
     * */
    @Column(name = "is_active", nullable = false)
    Boolean isActive;

    @ManyToMany
    private List<PhaseEntity> phases = new ArrayList<>();

    @ManyToMany
    private List<TeamEntity> teams = new ArrayList<>();
}
