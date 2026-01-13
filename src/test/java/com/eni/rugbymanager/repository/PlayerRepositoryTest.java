package com.eni.rugbymanager.repository;

import com.eni.rugbymanager.bo.Address;
import com.eni.rugbymanager.bo.Player;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PlayerRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(PlayerRepositoryTest.class);

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private AddressRepository addressRepository;

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
        assertEquals(today, savedPlayer.getBirthdate());
    }

    @Test
    void test_delete_whenPlayerIsDeleted_thenAddressIsDeleted() {
        // A
        Address address = Address.builder().street("rue du Général de Gaulle").city("Paris").zipCode("75001").build();
        Player player = Player.builder().firstName("Antoine").lastName("Dupont").birthdate(new Date()).address(address).build();
        Player savedPlayer = this.playerRepository.save(player);
        List<Player> players = this.playerRepository.findAll();
        List<Address> addresses = this.addressRepository.findAll();
        assertEquals(1, players.size());
        assertEquals(1, addresses.size());

        // A
        this.playerRepository.delete(savedPlayer);

        // A
        players = this.playerRepository.findAll();
        addresses = this.addressRepository.findAll();
        assertEquals(0, players.size());
        assertEquals(0, addresses.size());
    }

    @Test
    void test() {
        Address address = Address.builder().street("rue du Général de Gaulle").city("Paris").zipCode("75001").build();
        Player player = Player.builder().firstName("Antoine").lastName("Dupont").birthdate(new Date()).address(address).build();
        this.playerRepository.save(player);

        Address savedAddress = this.addressRepository.findAll().getFirst();;
        logger.info(savedAddress.toString());
    }
}
