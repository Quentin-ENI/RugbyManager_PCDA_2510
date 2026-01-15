package com.eni.rugbymanager.bo;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String street;

    @Column(nullable = false)
    private String city;

    @Column(nullable = true)
    private String zipCode;

    @ToString.Exclude
    @OneToOne(mappedBy="address")
    private Person person;
}
