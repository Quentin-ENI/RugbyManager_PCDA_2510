package com.eni.rugbymanager.bll.impl;

import com.eni.rugbymanager.bll.PlayerService;
import com.eni.rugbymanager.bo.Player;
import com.eni.rugbymanager.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;

    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    @Override
    public Player getById(long id) {
        return playerRepository.findById(id).orElse(null);
    }
}
