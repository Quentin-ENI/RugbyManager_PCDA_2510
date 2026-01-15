package com.eni.rugbymanager.repository;

import com.eni.rugbymanager.bo.Competition;
import com.eni.rugbymanager.bo.Player;
import com.eni.rugbymanager.bo.Team;
import com.eni.rugbymanager.bo.TeamKey;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class CompetitionRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(CompetitionRepositoryTest.class);

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    CompetitionRepository competitionRepository;

    @Test
    void test_findCompetitionsByPlayerById() {
        // Arrange
        TeamKey keyStadeToulousain = TeamKey.builder().name("Stade Toulousain").country("France").build();
        TeamKey keyBordeauxBegles = TeamKey.builder().name("Bordeaux Bègles").country("France").build();

        Competition top14 = Competition.builder().name("Top 14").build();
        Competition hCup = Competition.builder().name("H Cup").build();
        Competition fictiveCompetition = Competition.builder().name("Compétition fictive").build();

        competitionRepository.saveAll(Arrays.asList(top14, hCup, fictiveCompetition));

        Team stadeToulousain = Team.builder()
                .key(keyStadeToulousain)
                .creationDate(new Date())
                .build();
        Team bordeauxBegles = Team.builder()
                .key(keyBordeauxBegles)
                .creationDate(new Date())
                .build();

        Player antoine = Player.builder()
                .team(stadeToulousain)
                .firstName("Antoine")
                .lastName("Dupont")
                .birthdate(new Date())
                .position("Demi de mêlée")
                .build();
        Player thomas = Player.builder()
                .team(stadeToulousain)
                .firstName("Thomas")
                .lastName("Ramos")
                .birthdate(new Date())
                .position("Arrière")
                .build();
        Player louis = Player.builder()
                .team(bordeauxBegles)
                .firstName("Louis")
                .lastName("Bielle-Biarrey")
                .birthdate(new Date())
                .position("Ailier")
                .build();
        Player sylvain = Player.builder()
                .team(stadeToulousain)
                .firstName("Sylvain")
                .lastName("Dupont")
                .birthdate(new Date())
                .position("Pilier")
                .build();

        stadeToulousain.setPlayers(Arrays.asList(antoine, thomas, sylvain));
        bordeauxBegles.setPlayers(Arrays.asList(louis));

        stadeToulousain.setCompetitions(Arrays.asList(top14, hCup));
        bordeauxBegles.setCompetitions(Arrays.asList(top14, fictiveCompetition));

        teamRepository.saveAll(Arrays.asList(stadeToulousain, bordeauxBegles));
        teamRepository.flush();

        List<Competition> competitions = competitionRepository.findCompetitionsByPlayerById(3);

        logger.info(competitions.toString());

        List<Player> dupont = this.playerRepository.findPlayerByLastName("Dupont");
        logger.info(dupont.toString());
    }
}
