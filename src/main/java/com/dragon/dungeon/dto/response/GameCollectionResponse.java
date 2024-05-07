package com.dragon.dungeon.dto.response;

import java.util.List;

import com.dragon.dungeon.dto.models.GameCollectionModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class GameCollectionResponse {

    private List<GameCollectionModel> games;
    
}
