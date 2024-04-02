package com.gater.town.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Player {
    private MessageType type;
    private Region region;
    private int x,y;
    private String username;
    
    @Override
    public String toString() {
        return "Player [type=" + type + ", region=" + region + ", x=" + x + ", y=" + y + ", username="
                + username + "]";
    }

    
}
