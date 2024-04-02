package com.gater.town.config;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gater.town.domain.MessageType;
import com.gater.town.domain.Player;
import com.gater.town.domain.PlayerRoom;
import com.gater.town.service.PlayerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebsocketHandler extends TextWebSocketHandler {
    private final ObjectMapper objectMapper; 
    private final PlayerService playerService;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("websocket connection complete.");
        session.sendMessage(new TextMessage("You are connected."));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info(payload);
        Player player = objectMapper.readValue(payload, Player.class);
        PlayerRoom room = playerService.getRoom(player.getRegion());

        room.updatePlayer(session, player);
        room.sendAllPlayer();
    }

}


