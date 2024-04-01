package com.gater.town.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gater.town.domain.Player;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController //객체 반환하면 알아서 json 변환
public class PlayerController {

    @PostMapping("/register")
    public Player register(@RequestParam String username) {
        Player player = new Player();
        player.setUsername(username);
        return player;
    }

}
