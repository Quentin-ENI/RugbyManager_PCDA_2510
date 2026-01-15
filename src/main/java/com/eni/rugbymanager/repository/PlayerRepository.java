package com.eni.rugbymanager.repository;

import com.eni.rugbymanager.bo.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
//    @Query("SELECT p FROM Player p WHERE p.lastName = :lastName")
//    List<Player> findPlayerByLastName(@Param("lastName") String lastName);

    List<Player> findPlayerByLastName(String lastName);
}
