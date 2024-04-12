package com.gater.town.repository;

import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;


import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import com.gater.town.domain.Player;
import com.gater.town.dto.LoginDto;
import com.gater.town.dto.RegisterDto;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class PlayerRepository {
    public static Long seq = 1L;
    private static final Map<LoginDto, Player> playersInfo = new ConcurrentHashMap<>();

    public Player login(@Validated LoginDto loginDto) {
        Optional<Entry<LoginDto, Player>> first = playersInfo.entrySet().stream().filter(entry -> entry.getKey().isSame(loginDto)).findFirst();
        if (!first.isPresent())
            return null;
        Player p = first.get().getValue();
        log.info("login이 검색한 Player : " + p.toString());
        return p;
    }

    public Player register(RegisterDto registerDto) {
        log.info(registerDto.toString());

        String id = registerDto.getId();

        LoginDto check = playersInfo.keySet()
                .stream()
                .filter(login -> login.getId().equals(id))
                .findFirst()
                .orElse(null);
 
        if (check != null) return null;

        LoginDto loginDto = new LoginDto(registerDto.getId(), registerDto.getPassword());
        Player player = new Player(registerDto.getRegion(), registerDto.getUsername());
        player.setSeq(seq++);
        playersInfo.put(loginDto, player);
        log.info("register이 등록하는 함수 : " + player.toString());
        return player;
    }
    
}
