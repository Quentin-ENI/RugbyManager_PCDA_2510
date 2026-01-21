package com.eni.rugbymanager.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "pseudo")
@ToString(of = "pseudo")
public class AuthenticationRequest {
    private String pseudo;
    private String password;
}
