package com.gater.town.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gater.town.domain.Player;

@RestController //객체 반환하면 알아서 json 변환
public class PlayerController {

    @GetMapping("/")
    @ResponseBody
    public String test() {
        return "OK";
    }

    @PostMapping("/register")
    public Player register(@RequestParam String username) {
        Player player = new Player();
        player.setUsername(username);
        return player;
    }

}
