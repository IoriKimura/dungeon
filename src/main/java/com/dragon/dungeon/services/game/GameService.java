package com.dragon.dungeon.services.game;

import com.dragon.dungeon.dto.request.CreateGameRequest;
import com.dragon.dungeon.dto.response.CreateGameResponse;
import com.dragon.dungeon.dto.response.GameCollectionResponse;

public interface GameService {

    CreateGameResponse createGame(CreateGameRequest request, String uMail);

    GameCollectionResponse getCollection(String uMail);
    
}
