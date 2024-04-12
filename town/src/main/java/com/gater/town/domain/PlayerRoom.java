package com.gater.town.domain;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PlayerRoom {
    private Region region;
    private Map<Long, Player> players = new ConcurrentHashMap<>();

    public PlayerRoom(Region region) {
        this.region = region;
    }

    public void updatePlayer(Long seq, Player player) {
        players.put(seq, player);
    }

    public Collection<Player> getAll() {
        return players.values();
    }

}
