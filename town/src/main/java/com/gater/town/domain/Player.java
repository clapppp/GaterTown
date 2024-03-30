package com.gater.town.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Player {

    private int x;

    private int y;

    private Long id;

    private String username;

    
    public Player(String username) {
        this.username = username;
    }
}
