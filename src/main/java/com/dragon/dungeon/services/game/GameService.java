package com.dragon.dungeon.services.game;

import com.dragon.dungeon.dto.models.GameModel;
import com.dragon.dungeon.dto.request.CreateGameRequest;

public interface GameService {

    GameModel createGame(CreateGameRequest request);
    
}
