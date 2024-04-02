package com.gater.town.domain;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class PlayerRoom {
    private Region region;
    private Map<WebSocketSession, Player> players = new ConcurrentHashMap<>();
    private ObjectMapper objectMapper = new ObjectMapper();

    public PlayerRoom(Region region) {
        this.region = region;
    }

    public void updatePlayer(WebSocketSession session, Player player) {
        players.put(session, player);
    }

    public void sendAllPlayer() {
        Collection<Player> values = players.values();
        players.keySet().forEach(session -> sendMessage(session, values));
    }

    public void sendMessage(WebSocketSession session, Collection<Player> values) {
        try {
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(values)));
        } catch (IOException e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }

}
