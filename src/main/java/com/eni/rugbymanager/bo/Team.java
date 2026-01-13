package com.eni.rugbymanager.bo;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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
}
