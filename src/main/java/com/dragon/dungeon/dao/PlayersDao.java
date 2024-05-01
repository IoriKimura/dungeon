package com.dragon.dungeon.dao;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.dragon.dungeon.dto.request.AddPlayerRequest;
import com.dragon.dungeon.entities.GameEntity;
import com.dragon.dungeon.entities.PlayersEntity;
import com.dragon.dungeon.entities.PlayersId;
import com.dragon.dungeon.entities.UserEntity;
import com.dragon.dungeon.repositories.GamesRepo;
import com.dragon.dungeon.repositories.PlayersRepo;
import com.dragon.dungeon.repositories.UserRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PlayersDao {

    private final PlayersRepo playersRepo;

    private final UserRepo userRepo;

    private final GamesRepo gamesRepo;

    public boolean validateMaster(String mUmail, String gameId) {
        UserEntity user = userRepo.findByuMail(mUmail).orElseThrow();
        PlayersEntity player = playersRepo.getReferenceById(PlayersId.builder().gameId(UUID.fromString(gameId)).playerId(user.getUserId()).build());
        if(player.isMaster())
            return true;
        else
            return false;
    }

    public void addPlayer(AddPlayerRequest request){
        UserEntity user = userRepo.findByuMail(request.getUMail()).orElseThrow();
        GameEntity game = gamesRepo.getReferenceById(UUID.fromString(request.getGameId()));
        playersRepo.save(PlayersEntity.builder().gameId(game).playerId(user).isMaster(false).build());
    }
    
}
