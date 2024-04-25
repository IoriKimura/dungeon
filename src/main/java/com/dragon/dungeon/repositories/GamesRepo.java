package com.dragon.dungeon.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dragon.dungeon.entities.GameEntity;

@Repository
public interface GamesRepo extends JpaRepository<GameEntity, UUID>{

}
    
