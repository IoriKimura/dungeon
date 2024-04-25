package com.dragon.dungeon.dto.response;

import java.util.UUID;

import com.dragon.dungeon.dto.models.MapModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CreateGameResponse {

    private final UUID id;
    
    private final UUID owner;

    private final MapModel map;
}
