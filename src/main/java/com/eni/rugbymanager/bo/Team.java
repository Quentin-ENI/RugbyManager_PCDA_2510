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
            orphanRemoval = false,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY
    )
    @JoinColumns({
            @JoinColumn(name="team_name", referencedColumnName="name"),
            @JoinColumn(name="team_country", referencedColumnName="country")
    })
    private List<Player> players;

    @ManyToOne(optional = false)
    private Gender gender;

    @Builder.Default
    @ManyToMany(mappedBy="teams")
    private List<Competition> competitions = new ArrayList();
}
