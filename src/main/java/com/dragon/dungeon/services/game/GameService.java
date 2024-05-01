package com.dragon.dungeon.services.game;

import com.dragon.dungeon.dto.request.AddPlayerRequest;
import com.dragon.dungeon.dto.request.CreateGameRequest;
import com.dragon.dungeon.dto.response.CreateGameResponse;
import com.dragon.dungeon.dto.response.GameCollectionResponse;
import com.dragon.dungeon.dto.response.GameResponse;

public interface GameService {

    CreateGameResponse createGame(CreateGameRequest request, String uMail);

    GameCollectionResponse getCollection(String uMail);

    GameResponse getGame(String gameId, String uMail);

    GameCollectionResponse updatePlayersInGame(AddPlayerRequest request, String mUmail);
    
}
