package com.dragon.dungeon.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dragon.dungeon.entities.GameEntity;
import com.dragon.dungeon.entities.PlayersEntity;
import com.dragon.dungeon.entities.PlayersId;
import com.dragon.dungeon.entities.UserEntity;

@Repository
public interface PlayersRepo extends JpaRepository<PlayersEntity, PlayersId>{

    List<PlayersEntity> findByGameId(GameEntity gameId);

    List<PlayersEntity> findByPlayerId(UserEntity playerId);
}
    
