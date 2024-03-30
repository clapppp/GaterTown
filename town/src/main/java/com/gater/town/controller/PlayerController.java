package com.gater.town.controller;

import java.util.List;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.gater.town.domain.Player;
import com.gater.town.repository.PlayerRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PlayerController {
    
    private final PlayerRepository playerRepository;

    @MessageMapping("/render")
    @SendTo("/client")
    public List<Player> update(Player client) {
        playerRepository.updatePlayer(client);
        return playerRepository.allPlayer();
    }

}
