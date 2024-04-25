package com.dragon.dungeon.dto.request;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateGameRequest {
    
    private final String uMail;

    private final String mapId;
}
