package com.eni.rugbymanager.controller;

import com.eni.rugbymanager.bll.PlayerService;
import com.eni.rugbymanager.bll.impl.PlayerServiceImpl;
import com.eni.rugbymanager.bo.Player;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
