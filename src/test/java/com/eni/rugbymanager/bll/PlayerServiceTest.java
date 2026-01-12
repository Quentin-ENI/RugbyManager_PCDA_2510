package com.eni.rugbymanager.bll;

import com.eni.rugbymanager.bo.Player;
import com.eni.rugbymanager.repository.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PlayerServiceTest {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void test_createPlayers_works() {
        // A & A
        this.playerService.createPlayers();
        // A
        List<Player> players = this.playerRepository.findAll();
        assertEquals(4, players.size());
    }
}
