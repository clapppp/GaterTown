package com.gater.town.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Player {
    private Region region;
    private String username;
    private Long seq;
    private int x, y;

    public Player(Region region, String username) {
        this.region = region;
        this.username = username;
    }

}