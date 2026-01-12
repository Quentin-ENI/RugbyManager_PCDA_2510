package com.eni.rugbymanager.repository;

import com.eni.rugbymanager.bo.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void test_create_works() {
        //// AAA
        // Arrange
        Date today = new Date();

        Player player = Player.builder()
                .firstName("Antoine")
                .lastName("Dupont")
                .birthdate(today)
                .build();

        System.out.println(player);

        // Act
        Player savedPlayer = this.playerRepository.save(player);

        // Assert
        assertEquals(1L, savedPlayer.getId());
        assertEquals("Antoine", savedPlayer.getFirstName());
        assertEquals("Dupont", savedPlayer.getLastName());
        assertEquals(today, player.getBirthdate());
    }
}
