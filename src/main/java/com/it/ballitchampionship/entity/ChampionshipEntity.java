package com.it.ballitchampionship.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
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

    @OneToMany(mappedBy = "championship")
    private List<TeamEntity> teams;

}
