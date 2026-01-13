package com.eni.rugbymanager.bll;

import com.eni.rugbymanager.bo.Player;
import com.eni.rugbymanager.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class PlayerService {

    private PlayerRepository playerRepository;

//    public PlayerRepository(PlayerRepository playerRepository) {
//        this.playerRepository = playerRepository;
//    }

    public Player createPlayer() {
        Player player = Player
                .builder()
                .firstName("Thomas")
                .lastName("Ramos")
                .build();
        return player;
    }

    public void createPlayers() {
        Player ramos = Player
                .builder()
                .firstName("Thomas")
                .lastName("Ramos")
                .birthdate(new Date())
                .build();
        Player dupont = Player
                .builder()
                .firstName("Antoine")
                .lastName("Dupont")
                .birthdate(new Date())
                .build();
        Player bb = Player
                .builder()
                .firstName("Louis")
                .lastName("Bielle-Biarey")
                .birthdate(new Date())
                .build();
        Player leGarrec = Player
                .builder()
                .firstName("Nolan")
                .lastName("Le Garrec")
                .birthdate(new Date())
                .build();

        List<Player> players = new ArrayList();
        players.add(ramos);
        players.add(dupont);
        players.add(bb);
        players.add(leGarrec);

        for (Player player: players) {
            this.playerRepository.save(player);
        }
    }
}
