package com.dragon.dungeon.repositories.character;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dragon.dungeon.entities.character.AttackSpellsEntity;

@Repository
public interface AttackSpellsRepo extends JpaRepository<AttackSpellsEntity, UUID>{
    
}
