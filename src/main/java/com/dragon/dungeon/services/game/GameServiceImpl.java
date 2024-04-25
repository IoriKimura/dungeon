package com.dragon.dungeon.services.game;

import org.springframework.stereotype.Service;

import com.dragon.dungeon.dao.GameDao;
import com.dragon.dungeon.dto.models.GameModel;
import com.dragon.dungeon.dto.request.CreateGameRequest;
import com.dragon.dungeon.dto.response.CreateGameResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService{

    private final GameDao gameDao;

    @Override
    public CreateGameResponse createGame(CreateGameRequest request) {
        
        GameModel game = gameDao.createGame(request);

        return CreateGameResponse.builder()
            .id(game.getId())
            .owner(game.getPlayers().get(0).getUser().getId())
            .map(game.getMap())
        .build();
    }
    
}
