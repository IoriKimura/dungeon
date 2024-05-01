package com.dragon.dungeon.entities;

import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayersId implements Serializable {
    private UUID gameId;
    private UUID playerId;

    // геттеры и сеттеры
}
