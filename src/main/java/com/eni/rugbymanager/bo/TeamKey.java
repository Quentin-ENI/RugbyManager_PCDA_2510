package com.eni.rugbymanager.bo;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class TeamKey implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String country;
}
