package com.it.ballitchampionship.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
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

    @Column(name = "teams")
    @OneToMany(mappedBy = "championship")
    private List<TeamEntity> teams;

}
