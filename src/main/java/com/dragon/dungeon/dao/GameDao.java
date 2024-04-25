package com.dragon.dungeon.dao;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.dragon.dungeon.dto.models.GameModel;
import com.dragon.dungeon.dto.request.CreateGameRequest;
import com.dragon.dungeon.entities.GameEntity;
import com.dragon.dungeon.entities.PlayersEntity;
import com.dragon.dungeon.entities.UserEntity;
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

    public GameModel createGame(CreateGameRequest request){
        UserEntity user = userRepo.findByuMail(request.getUMail()).orElseThrow();
        GameEntity game = gamesRepo.save(GameEntity.builder()
            .mapId(mapsRepo.getReferenceById((UUID.fromString(request.getMapId())))).build());
        PlayersEntity player = PlayersEntity.builder()
            .gameId(game)
            .playerId(user)
            .build();
        
        playersRepo.save(player);

        return GameModel.fromEntity(gamesRepo.getReferenceById(game.getId()), player);
    }
    
}
