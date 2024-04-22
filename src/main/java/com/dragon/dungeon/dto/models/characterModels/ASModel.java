package com.dragon.dungeon.dto.models.characterModels;

import java.util.UUID;

import com.dragon.dungeon.entities.character.AttackSpellsEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ASModel {

    private UUID id;

    private String attack;
    
    public static ASModel fromEntity(AttackSpellsEntity attacks){
        
        return ASModel.builder()
            .id(attacks.getId())
            .attack(attacks.getAttack())
            .build();
    }
}
