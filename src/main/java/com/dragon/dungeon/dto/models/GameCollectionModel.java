package com.dragon.dungeon.dto.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.dragon.dungeon.entities.GameEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameCollectionModel {

    private UUID id;

    private List<UserGameModel> players;

    private MapModel map;

     public static List<GameCollectionModel> listFromListOfEntity(List<GameEntity> games){
        List<GameCollectionModel> listOfGames = new ArrayList<>();
        for (GameEntity game : games) {
            GameCollectionModel gameCollectionModel = GameCollectionModel.builder()
                    .id(game.getId())
                    .map(MapModel.fromEntity(game.getMapId()))
                    .players(UserGameModel.listFromListOfEntity(game.getOwnerId()))
                    .build();
                    listOfGames.add(gameCollectionModel);
        }
        return listOfGames;
    }
    
}
