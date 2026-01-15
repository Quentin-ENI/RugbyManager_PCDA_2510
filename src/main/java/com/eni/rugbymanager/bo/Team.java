package com.eni.rugbymanager.bo;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"players", "competitions"})
@Builder
@Entity
//@IdClass(TeamKey.class)       // Méthode 1
public class Team {
//    @Id                       // Méthode 1
//    private String name;
//    @Id
//    private String country;

    @EmbeddedId
    private TeamKey key;

    @Column(nullable=false)
    private Date creationDate;

    @OneToMany(
            mappedBy = "team",  // Ajouté
            orphanRemoval = false,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY
    )
    private List<Player> players;

    @Builder.Default
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "competition_teams",
            joinColumns = {
                    @JoinColumn(name = "team_name", referencedColumnName = "name"),
                    @JoinColumn(name = "team_country", referencedColumnName = "country")
            },
            inverseJoinColumns = @JoinColumn(name = "competition_id")
    )
    private List<Competition> competitions = new ArrayList();
}
