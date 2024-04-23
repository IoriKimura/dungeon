package com.dragon.dungeon.repositories.character;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dragon.dungeon.entities.character.SkillsEntity;

@Repository
public interface SkillsRepo extends JpaRepository<SkillsEntity, UUID>{
    
}
