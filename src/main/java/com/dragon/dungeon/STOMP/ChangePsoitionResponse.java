package com.dragon.dungeon.STOMP;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ChangePsoitionResponse {

    private final UUID id;

    private final int posX;

    private final int posY;
  
  }