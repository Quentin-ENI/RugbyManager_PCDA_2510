package com.eni.rugbymanager.controller;

import com.eni.rugbymanager.bll.PlayerService;
import com.eni.rugbymanager.bll.impl.PlayerServiceImpl;
import com.eni.rugbymanager.bo.Player;
import com.eni.rugbymanager.dto.PlayerDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/players")
public class PlayerController {

    private PlayerService playerService;

    @GetMapping
    public ResponseEntity<?> getPlayers() {
        List<Player> players = this.playerService.getAll();

        return ResponseEntity.ok(players);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPlayerById(@PathVariable("id") long playerId) {
        Player player = this.playerService.getById(playerId);
        if (player == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(player);
    }

    @PostMapping()
    public ResponseEntity<?> createPlayer(@RequestBody PlayerDTO playerDTO) {
        Player player = Player.builder()
                .firstName(playerDTO.getFirstName())
                .lastName(playerDTO.getLastName())
                .birthdate(playerDTO.getBirthdate())
                .position(playerDTO.getPosition())
                .build();
        Player savedPlayer = this.playerService.createPlayer(player);
        PlayerDTO responsePlayerDTO = new PlayerDTO(
                savedPlayer.getId(),
                savedPlayer.getFirstName(),
                savedPlayer.getLastName(),
                savedPlayer.getPosition(),
                savedPlayer.getBirthdate()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(responsePlayerDTO);
    }

}
