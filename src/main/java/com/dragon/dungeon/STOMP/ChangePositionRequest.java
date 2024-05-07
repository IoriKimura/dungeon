package com.dragon.dungeon.STOMP;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ChangePositionRequest {

    private final UUID id;

    private final int posX;

    private final int posY;
    

  }
