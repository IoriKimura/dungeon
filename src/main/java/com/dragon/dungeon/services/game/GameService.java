package com.dragon.dungeon.services.game;

import com.dragon.dungeon.dto.request.CreateGameRequest;
import com.dragon.dungeon.dto.response.CreateGameResponse;

public interface GameService {

    CreateGameResponse createGame(CreateGameRequest request);
    
}
