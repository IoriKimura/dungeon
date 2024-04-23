package com.dragon.dungeon.dao;

import org.springframework.stereotype.Component;

import com.dragon.dungeon.dto.models.characterModels.ASModel;
import com.dragon.dungeon.entities.character.AttackSpellsEntity;
import com.dragon.dungeon.repositories.character.AttackSpellsRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AttackSpellsDao {

    private final AttackSpellsRepo attackSpellsRepo;

    public AttackSpellsEntity saveEntity(ASModel asModel){
        return attackSpellsRepo.save(AttackSpellsEntity.builder()
                .attack(asModel.getAttack())
            .build());
    }
    
}
