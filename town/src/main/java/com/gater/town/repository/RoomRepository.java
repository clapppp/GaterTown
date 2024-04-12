package com.gater.town.repository;

import java.util.Collection;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gater.town.domain.PlayerRoom;
import com.gater.town.domain.Region;


@Repository
public class RoomRepository {
    private static final Map<Region, PlayerRoom> rooms = Map.of(
        Region.SEOUL, new PlayerRoom(Region.SEOUL),
        Region.BUSAN, new PlayerRoom(Region.BUSAN),
        Region.DAEGU, new PlayerRoom(Region.DAEGU),
        Region.INCHN, new PlayerRoom(Region.INCHN)
    );

    public PlayerRoom getRoom(Region region) {
        return rooms.get(region);
    }

    public Collection<PlayerRoom> getAll() {
        return rooms.values();
    }

}
