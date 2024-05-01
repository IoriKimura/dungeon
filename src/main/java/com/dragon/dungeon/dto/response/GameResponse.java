package com.dragon.dungeon.dto.response;

import java.util.List;
import java.util.UUID;

import com.dragon.dungeon.dto.models.MapModel;
import com.dragon.dungeon.dto.models.UserGameModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameResponse {

    private UUID id;

    private List<UserGameModel> players;

    private MapModel map;
    
}
