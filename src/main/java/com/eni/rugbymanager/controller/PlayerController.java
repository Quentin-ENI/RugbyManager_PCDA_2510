package com.eni.rugbymanager.controller;

import com.eni.rugbymanager.bll.PlayerService;
import com.eni.rugbymanager.bo.Player;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PlayerController {

    private PlayerService playerService;

    @GetMapping("/player")
    public Player getPlayer() {
        Player player = this.playerService.createPlayer();
        System.out.println(player);
        return player;
    }

}
