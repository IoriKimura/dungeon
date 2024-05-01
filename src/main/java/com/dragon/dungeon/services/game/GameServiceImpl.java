package com.dragon.dungeon.services.game;

import org.springframework.stereotype.Service;

import com.dragon.dungeon.dao.GameDao;
import com.dragon.dungeon.dao.PlayersDao;
import com.dragon.dungeon.dto.models.GameModel;
import com.dragon.dungeon.dto.models.UserGameModel;
import com.dragon.dungeon.dto.request.AddPlayerRequest;
import com.dragon.dungeon.dto.request.CreateGameRequest;
import com.dragon.dungeon.dto.response.CreateGameResponse;
import com.dragon.dungeon.dto.response.GameCollectionResponse;
import com.dragon.dungeon.dto.response.GameResponse;
import com.dragon.dungeon.entities.UserEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService{

    private final GameDao gameDao;

    private final PlayersDao playersDao;

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

    @Override
    public GameResponse getGame(String gameId, String uMail) {
        return gameDao.getGame(gameId, uMail);
    }

    @Override
    public GameCollectionResponse updatePlayersInGame(AddPlayerRequest request, String mUmail){

        if(playersDao.validateMaster(mUmail, request.getGameId())){
            playersDao.addPlayer(request);
            return GameCollectionResponse.builder().games(gameDao.getCollection(mUmail)).build();
        }

        return null;


    }
    
}
