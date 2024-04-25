package com.dragon.dungeon.repositories.character;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dragon.dungeon.entities.character.CharacterEntity;
import java.util.List;
import com.dragon.dungeon.entities.UserEntity;


@Repository
public interface CharacterRepo extends JpaRepository<CharacterEntity, UUID> {
    
    List<CharacterEntity> findByOwner(UserEntity owner);
}
