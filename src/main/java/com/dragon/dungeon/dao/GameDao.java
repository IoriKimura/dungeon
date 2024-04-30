package com.dragon.dungeon.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.dragon.dungeon.dto.models.CollectionModel;
import com.dragon.dungeon.dto.models.GameCollectionModel;
import com.dragon.dungeon.dto.models.GameModel;
import com.dragon.dungeon.dto.models.MapModel;
import com.dragon.dungeon.dto.request.CreateGameRequest;
import com.dragon.dungeon.entities.GameEntity;
import com.dragon.dungeon.entities.MapEntity;
import com.dragon.dungeon.entities.PlayersEntity;
import com.dragon.dungeon.entities.UserEntity;
import com.dragon.dungeon.entities.character.CharacterEntity;
import com.dragon.dungeon.repositories.GamesRepo;
import com.dragon.dungeon.repositories.MapsRepo;
import com.dragon.dungeon.repositories.PlayersRepo;
import com.dragon.dungeon.repositories.UserRepo;

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
            .build();
        
        playersRepo.save(player);

        return GameModel.fromEntity(gamesRepo.getReferenceById(game.getId()), player);
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
    
}
