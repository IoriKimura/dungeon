package com.dragon.dungeon.entities;

import java.io.Serializable;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PlayersId implements Serializable {
    private UUID gameId;
    private UUID playerId;

    // геттеры и сеттеры
}
