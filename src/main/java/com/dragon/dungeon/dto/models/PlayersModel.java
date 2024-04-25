package com.dragon.dungeon.dto.models;

import java.util.ArrayList;
import java.util.List;

import com.dragon.dungeon.entities.GameEntity;
import com.dragon.dungeon.entities.PlayersEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayersModel {

    //private GameEntity game;

    private UserModel user;

    public static List<PlayersModel> listFromListOfEntity(List<PlayersEntity> players){
        List<PlayersModel> listOfPlayers = new ArrayList<>();
        for (PlayersEntity player : players) {
            PlayersModel playersModel = PlayersModel.builder()
                    //.game(player.getGameId())
                    .user(UserModel.fromEntity(player.getPlayerId()))
                    .build();
            listOfPlayers.add(playersModel);
        }
        return listOfPlayers;
    }

    public static List<PlayersModel> listFromEntity(PlayersEntity owner) {
        List<PlayersModel> listOfPlayers = new ArrayList<>();
        PlayersModel playersModel = PlayersModel.builder()
                //.game(owner.getGameId())
                .user(UserModel.fromEntity(owner.getPlayerId()))
                .build();
        listOfPlayers.add(playersModel);
        return listOfPlayers;
    }
    
}
