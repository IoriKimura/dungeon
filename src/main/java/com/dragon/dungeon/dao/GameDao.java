package com.dragon.dungeon.dao;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.dragon.dungeon.dto.models.GameCollectionModel;
import com.dragon.dungeon.dto.models.GameModel;
import com.dragon.dungeon.dto.models.UserGameModel;
import com.dragon.dungeon.dto.request.CreateGameRequest;
import com.dragon.dungeon.dto.response.GameResponse;
import com.dragon.dungeon.entities.GameEntity;
import com.dragon.dungeon.entities.PlayersEntity;
import com.dragon.dungeon.entities.PlayersId;
import com.dragon.dungeon.entities.UserEntity;
import com.dragon.dungeon.repositories.GamesRepo;
import com.dragon.dungeon.repositories.MapsRepo;
import com.dragon.dungeon.repositories.PlayersRepo;
import com.dragon.dungeon.repositories.UserRepo;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GameDao {

    private final GamesRepo gamesRepo;

    private final UserRepo userRepo;

    private final MapsRepo mapsRepo;

    private final PlayersRepo playersRepo;

    public GameModel createGame(CreateGameRequest request, String uMail){
        UserEntity user = userRepo.findByuMail(uMail).orElseThrow();
        GameEntity game = gamesRepo.save(GameEntity.builder()
            .mapId(mapsRepo.getReferenceById((UUID.fromString(request.getMapId())))).build());
        PlayersEntity player = PlayersEntity.builder()
            .gameId(game)
            .playerId(user)
            .isMaster(true)
            .build();
        
        playersRepo.save(player);

        return GameModel.fromGameAndPlayers(gamesRepo.getReferenceById(game.getId()), player);
    }

    public List<GameCollectionModel> getCollection(String uMail) {
        try {
            UserEntity user = userRepo.findByuMail(uMail).orElseThrow();

            List<GameEntity> games = user.getGames();

            List<GameCollectionModel> collection = GameCollectionModel.listFromListOfEntity(games);

            return collection;
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public List<GameCollectionModel> getCollection(UserEntity user) {
        try {

            List<GameEntity> games = user.getGames();

            List<GameCollectionModel> collection = GameCollectionModel.listFromListOfEntity(games);

            return collection;
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public GameResponse getGame(String gameId, String uMail) {
        try {
            UserEntity user = userRepo.findByuMail(uMail).orElseThrow();
            PlayersEntity entity = playersRepo.getReferenceById(PlayersId.builder().gameId(UUID.fromString(gameId)).playerId(user.getUserId()).build());
            GameEntity game = gamesRepo.getReferenceById(entity.getGameId().getId());
            GameModel gameFromEntity = GameModel.fromEntity(game);  
            return GameResponse.builder()
                .id(gameFromEntity.getId())
                .players(UserGameModel.listFromModel(gameFromEntity.getPlayers()))
                .map(gameFromEntity.getMap())
                .build();
        } catch (EntityNotFoundException e) {
            return null;
        }   
    }

    public void updatePlayersList(String uMail, String gameId){
        GameEntity game = gamesRepo.getReferenceById(UUID.fromString(gameId));
        UserEntity user = userRepo.findByuMail(uMail).orElseThrow();
        playersRepo.save(PlayersEntity.builder().gameId(game).playerId(user).build());
    }
    
}
