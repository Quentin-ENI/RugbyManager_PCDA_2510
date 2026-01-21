package com.eni.rugbymanager.security;

import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class RugbyManagerSecurityConfig {
    @Autowired
    private Filter jwtAuthenticationFilter;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) {
        http.authorizeHttpRequests(auth ->
                auth
                    .requestMatchers(HttpMethod.GET, "/players/**").hasAnyRole("ADMIN", "USER")
                    .requestMatchers(HttpMethod.POST, "/players").hasAnyRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/players").hasAnyRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/players").hasAnyRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/auth").permitAll()
                    .anyRequest().denyAll()
        );

        http.csrf(csrf -> {
            csrf.disable();
        });

        // Connexion de l'utilisation
        http.authenticationProvider(authenticationProvider);

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        http.sessionManagement(session -> {
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        });

        return http.build();
    }
}
