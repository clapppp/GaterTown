package com.gater.town.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.gater.town.domain.PlayerRoom;
import com.gater.town.domain.Region;


@Service
public class PlayerService {
    private static final Map<Region, PlayerRoom> rooms = Map.of(
        Region.SEOUL, new PlayerRoom(Region.SEOUL),
        Region.BUSAN, new PlayerRoom(Region.BUSAN),
        Region.ULSAN, new PlayerRoom(Region.ULSAN)
    );

    public PlayerRoom getRoom(Region region) {
        return rooms.get(region);
    }

}
