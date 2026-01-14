package com.eni.rugbymanager.bo;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLAYER_ID")
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

    @ManyToOne
    private Team team;
}
