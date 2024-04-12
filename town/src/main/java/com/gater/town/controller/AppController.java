package com.gater.town.controller;


import java.util.Collection;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gater.town.domain.Player;
import com.gater.town.domain.PlayerRoom;
import com.gater.town.domain.Region;
import com.gater.town.dto.LoginDto;
import com.gater.town.dto.RegisterDto;
import com.gater.town.repository.PlayerRepository;
import com.gater.town.repository.RoomRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AppController {

    private final RoomRepository roomRepository;
    private final PlayerRepository playerRepository;

    @PostMapping("/login")
    public Player login(@RequestBody LoginDto login) {
        log.info("--form is submitted.--");
        return playerRepository.login(login);
    }

    @PostMapping("/register")
    public Player register(@Validated @RequestBody RegisterDto register) {;
        return playerRepository.register(register);
    }

    @GetMapping("/rooms")
    public Collection<PlayerRoom> rooms() {
        return roomRepository.getAll();
    }

    @GetMapping("/regions")
    public Region[] regions() {
        return Region.values();
    }

}
