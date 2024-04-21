package com.dragon.repositories.character;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dragon.dungeon.entities.character.CharacterEntity;

@Repository
public interface CharacterRepo extends JpaRepository<CharacterEntity, UUID> {
    
}
