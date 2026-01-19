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

    public List<Player> getAll() {
        return playerRepository.findAll();
    }
}
