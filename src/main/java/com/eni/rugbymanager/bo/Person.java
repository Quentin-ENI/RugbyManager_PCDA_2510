package com.eni.rugbymanager.bo;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLAYER_ID")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 200)
    private String lastName;

    @Column(nullable = false)
    private Date birthdate;

    @OneToOne(
            orphanRemoval = false,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "FK_PLAYER_ADDRESS")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({  // Déplacé de Teams -> Person
        @JoinColumn(name="team_name", referencedColumnName="name"),
        @JoinColumn(name="team_country", referencedColumnName="country")
    })
    @ToString.Exclude
    private Team team;
}
