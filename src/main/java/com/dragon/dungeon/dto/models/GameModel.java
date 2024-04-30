package com.dragon.dungeon.dto.models;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.dragon.dungeon.entities.GameEntity;
import com.dragon.dungeon.entities.PlayersEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameModel {
    
    private UUID id;
    
    private List<PlayersModel> players;

    private MapModel map;

    public static GameModel fromEntity(GameEntity game, PlayersEntity player){
        List<PlayersEntity> players = new ArrayList<>() ;
        players.add(player);
        return GameModel.builder()
            .id(game.getId())
            .players(PlayersModel.listFromEntity(player))
            .map(MapModel.fromEntity(game.getMapId()))
        .build();
    }

    public static List<GameModel> listFromListOfEntity(List<GameEntity> games){
        List<GameModel> listOfGames = new ArrayList<>();
        for (GameEntity game : games) {
            GameModel gameModel = GameModel.builder()
                    //.game(player.getGameId())
                    .id(game.getId())
                    .map(MapModel.fromEntity(game.getMapId()))
                    .players(PlayersModel.listFromListOfEntity(game.getOwnerId()))
                    .build();
                    listOfGames.add(gameModel);
        }
        return listOfGames;
    }
}
