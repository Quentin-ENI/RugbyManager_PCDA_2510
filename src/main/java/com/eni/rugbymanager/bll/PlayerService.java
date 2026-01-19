package com.eni.rugbymanager.bll;

import com.eni.rugbymanager.bo.Player;

import java.util.List;

public interface PlayerService {
    List<Player> getAll();
    Player getById(long id);
}
