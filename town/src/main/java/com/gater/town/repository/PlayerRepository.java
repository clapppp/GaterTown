package com.gater.town.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import com.gater.town.domain.Player;
import com.gater.town.dto.LoginDto;
import com.gater.town.dto.RegisterDto;

@Repository
public class PlayerRepository {
    private static final Map<LoginDto, Player> playersInfo = new ConcurrentHashMap<>();

    public Player login(@Validated LoginDto loginDto) {
        return playersInfo.get(loginDto);
    }

    public Player register(@Validated RegisterDto registerDto) {
        String id = registerDto.getId();

        LoginDto check = playersInfo.keySet()
                .stream()
                .filter(login -> login.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (check != null)
            return null;

        LoginDto loginDto = new LoginDto(registerDto.getId(), registerDto.getPassword());
        Player player = new Player(registerDto.getRegion(), registerDto.getUsername());
        return playersInfo.put(loginDto, player);
    }
    
}
