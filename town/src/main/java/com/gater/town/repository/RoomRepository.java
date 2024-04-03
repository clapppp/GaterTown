package com.gater.town.repository;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.gater.town.domain.PlayerRoom;
import com.gater.town.domain.Region;


@Service
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

}
