package com.dragon.dungeon.services.game;

import org.springframework.stereotype.Service;

import com.dragon.dungeon.dao.GameDao;
import com.dragon.dungeon.dto.models.GameModel;
import com.dragon.dungeon.dto.request.CreateGameRequest;
import com.dragon.dungeon.dto.response.CreateGameResponse;
import com.dragon.dungeon.dto.response.GameCollectionResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService{

    private final GameDao gameDao;

    @Override
    public CreateGameResponse createGame(CreateGameRequest request, String uMail) {
        
        GameModel game = gameDao.createGame(request, uMail);

        return CreateGameResponse.builder()
            .id(game.getId())
            .owner(game.getPlayers().get(0).getUser().getId())
            .map(game.getMap())
        .build();
    }

    @Override
    public GameCollectionResponse getCollection(String uMail) {
        return GameCollectionResponse.builder()
            .games(gameDao.getCollection(uMail)).build();
    }
    
}
