package com.eni.rugbymanager.repository;

import com.eni.rugbymanager.bo.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Integer> {
    @Query("SELECT DISTINCT c FROM Competition c JOIN c.teams t JOIN t.players p WHERE p.id = :id")
    List<Competition> findCompetitionsByPlayerById(@Param("id") Integer id);
}
