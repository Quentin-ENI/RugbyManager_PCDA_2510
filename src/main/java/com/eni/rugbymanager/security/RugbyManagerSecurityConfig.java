package com.eni.rugbymanager.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class RugbyManagerSecurityConfig {
    @Bean
    UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT pseudo, password, 1 FROM users WHERE pseudo = ?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT pseudo, authority FROM users WHERE pseudo = ?");

        return jdbcUserDetailsManager;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) {
        http.authorizeHttpRequests(auth ->
                auth
                    .requestMatchers(HttpMethod.GET, "/players/**").hasAnyRole("ADMIN", "USER")
                    .requestMatchers(HttpMethod.POST, "/players").hasAnyRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/players").hasAnyRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/players").hasAnyRole("ADMIN")
                    .anyRequest().denyAll()
        );

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> {
            csrf.disable();
        });

        return http.build();
    }
}
