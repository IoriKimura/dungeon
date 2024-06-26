package com.dragon.dungeon.repositories.character;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dragon.dungeon.entities.character.SavingThrowsEntity;

@Repository
public interface ThrowsRepo extends JpaRepository<SavingThrowsEntity, UUID>{
    
}
