package com.eni.rugbymanager.controller;

import com.eni.rugbymanager.bll.PlayerService;
import com.eni.rugbymanager.bo.Player;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PlayerController {

    private PlayerService playerService;

    @GetMapping("/player")
    public ResponseEntity<?> getPlayers() {
        List<Player> players = this.playerService.getAll();

        return ResponseEntity.ok(players);
    }

}
