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
    private Long id;
    private String username;
}
