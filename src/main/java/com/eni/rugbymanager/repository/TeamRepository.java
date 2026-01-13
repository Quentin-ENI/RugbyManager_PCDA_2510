package com.eni.rugbymanager.repository;

import com.eni.rugbymanager.bo.Team;
import com.eni.rugbymanager.bo.TeamKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, TeamKey> {
}
