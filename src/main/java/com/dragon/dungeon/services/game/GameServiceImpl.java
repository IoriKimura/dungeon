package com.dragon.dungeon.services.game;

import org.springframework.stereotype.Service;

import com.dragon.dungeon.dao.GameDao;
import com.dragon.dungeon.dto.models.GameModel;
import com.dragon.dungeon.dto.request.CreateGameRequest;
import com.dragon.dungeon.entities.GameEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService{

    private final GameDao gameDao;

    @Override
    public GameModel createGame(CreateGameRequest request) {

        return gameDao.createGame(request);
    }
    
}
