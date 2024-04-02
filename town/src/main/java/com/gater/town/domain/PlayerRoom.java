package com.gater.town.domain;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.lang.NonNull;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class PlayerRoom {
    private ObjectMapper objectMapper = new ObjectMapper();
    private Region region;
    private Map<WebSocketSession, Player> players = new ConcurrentHashMap<>();

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
            session.sendMessage(objectToTextMessage(values));
        } catch (IOException e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }

    @NonNull
    private TextMessage objectToTextMessage(Collection<Player> values) throws JsonProcessingException{
        return new TextMessage(objectMapper.writeValueAsString(values));
    }

}
