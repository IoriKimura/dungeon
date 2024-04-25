package com.dragon.dungeon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dragon.dungeon.entities.PlayersEntity;
import com.dragon.dungeon.entities.PlayersId;

@Repository
public interface PlayersRepo extends JpaRepository<PlayersEntity, PlayersId>{
}
    
