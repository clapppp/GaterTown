package com.gater.town.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gater.town.domain.Player;
import com.gater.town.dto.LoginDto;
import com.gater.town.dto.RegisterDto;
import com.gater.town.repository.PlayerRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AppController {

    private final PlayerRepository playerRepository;

    @PostMapping("/login")
    public Player login(LoginDto login) {
        return playerRepository.login(login);
    }

    @PostMapping("/register")
    public Player register(RegisterDto register) {
        return playerRepository.register(register);
    }



}
