package com.dragon.dungeon.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dragon.dungeon.entities.GameEntity;
import com.dragon.dungeon.entities.PlayersEntity;

@Repository
public interface GamesRepo extends JpaRepository<GameEntity, UUID>{

    List<GameEntity> findByOwnerId(PlayersEntity owner);

}
    
