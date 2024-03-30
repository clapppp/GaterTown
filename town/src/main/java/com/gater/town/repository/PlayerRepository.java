package com.gater.town.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.gater.town.domain.Player;

@Repository
public class PlayerRepository {
    private static final Map<Long, Player> playerList = new ConcurrentHashMap<>();
    private static Long seqLong = 1L;

    public void updatePlayer(Player player) {
        Player playerInDb = playerList.get(player.getId());
        playerInDb.setX(player.getX());
        playerInDb.setY(player.getY());
    }

    public void addPlayer(Player player) {
        player.setId(seqLong);
        playerList.put(seqLong, player);
        seqLong++;
    }

    public List<Player> allPlayer() {
        return new ArrayList<>(playerList.values());
    }

}
