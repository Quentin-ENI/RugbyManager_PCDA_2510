package com.eni.rugbymanager.bo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PlayerTest {
    @Test
    void test_patternBuilder_allAttributes() {
        //// AAA
        // Arrange
        // Préparation du test
        Player player = null;

        // Act
        // Exécution de la méthode à tester
        player = Player.builder().firstName("Antoine").lastName("Dupont").build();

        // Assert
        // Vérification des résultats
        assertEquals("Antoine", player.getFirstName());
        assertEquals("Dupont", player.getLastName());
    }
}
