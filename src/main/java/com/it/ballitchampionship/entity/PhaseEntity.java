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

    @ManyToMany(mappedBy = "phases")
    private List<TeamEntity> teams;

    @OneToMany(mappedBy = "phases")
    private List<MatchEntity> matches;
}
