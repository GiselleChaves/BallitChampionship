package com.it.ballitchampionship.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Table(name = "TB_TEAM")
@Entity
@NoArgsConstructor
public class TeamEntity {

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
     * The String "name" will store the team´s name
     * The column can´t be null
    */
    @Column(name = "name", nullable = false)
    String name;

    /*
     * The String "war cry" will store the team´s war cry
     * The column can´t be null
     */
    @Column(name = "war_cry", nullable = false)
    String warCry;

    /*
     * The String "foundation year" will store the team´s foundation year
     * The column can´t be null
     */
    @Column(name = "foundation_year", nullable = false)
    String foundationYear;

    @ManyToMany
    @JoinTable(
            name = "teams_matches",
            joinColumns = @JoinColumn (name = "team_id"),
            inverseJoinColumns = @JoinColumn (name = "match_id")
    )
    List<MatchEntity> matches;

    @ManyToMany
    private List<ChampionshipEntity> championships = new ArrayList<>();

    @ManyToMany
    private List<PhaseEntity> phases = new ArrayList<>();
}
