package com.gater.town.controller;

import java.util.Collection;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.gater.town.domain.Player;
import com.gater.town.domain.PlayerRoom;
import com.gater.town.domain.Region;
import com.gater.town.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UpdateController {
    private final RoomRepository roomRepository;

    @MessageMapping("/gatertown/update/{region}")
    @SendTo("/topic/gatertown/{region}")
    public Collection<Player> update(@DestinationVariable Region region, @Payload Player player) {
        PlayerRoom room = roomRepository.getRoom(region);
        room.updatePlayer(player.getSeq(), player);
        return room.getAll();
    }

}
