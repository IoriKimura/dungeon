package com.dragon.dungeon.dto.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.dragon.dungeon.entities.PlayersEntity;
import com.dragon.dungeon.entities.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserGameModel {

    private UUID id;

    private String uName;


    // public static UserGameModel fromEntity(UserEntity user){
    //     return UserGameModel.builder()
    //         .id(user.getUserId())
    //         .uName(user.getUName())
    //         .build();
    // }

    public static List<UserGameModel> listFromListOfEntity(List<PlayersEntity> players){
        List<UserGameModel> listOfPlayers = new ArrayList<>();
        for (PlayersEntity player : players) {
            UserGameModel playersModel = UserGameModel.builder()
                    //.game(player.getGameId())
                    .id(player.getPlayerId().getUserId())
                    .uName(player.getPlayerId().getUName())
                    .build();
            listOfPlayers.add(playersModel);
        }
        return listOfPlayers;
    }
}
