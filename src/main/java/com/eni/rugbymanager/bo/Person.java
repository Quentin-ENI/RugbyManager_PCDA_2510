package com.eni.rugbymanager.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
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
    @NotBlank(message = "{person.first-name.not-blank}")
    @NotNull(message = "Le prénom ne peut pas être null")
    private String firstName;

    @Column(nullable = false, length = 200)
    @NotBlank(message = "Le nom de famille doit être renseigné")
    @NotNull(message = "Le nom de famille ne peut pas être null")
    private String lastName;

    @Column(nullable = false)
    @Past(message = "La date de naissance ne peut pas se situer dans le futur")
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
