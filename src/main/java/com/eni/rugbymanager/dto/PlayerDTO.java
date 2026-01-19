package com.eni.rugbymanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private Date birthdate;
}
