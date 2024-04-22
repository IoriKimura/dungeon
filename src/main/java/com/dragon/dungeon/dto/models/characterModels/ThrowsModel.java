package com.dragon.dungeon.dto.models.characterModels;

import java.util.UUID;

import com.dragon.dungeon.entities.character.SavingThrowsEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ThrowsModel {

    private UUID id;

    private int isStrength;
    
    private int isDexterity;

    private int isConstitution;

    private int isIntelligence;

    private int isWisdom;

    private int isCharisma;

    public static ThrowsModel fromEntity(SavingThrowsEntity throwsFromDb){
        
        return ThrowsModel.builder()
            .id(throwsFromDb.getId())
            .isStrength(throwsFromDb.getIsStrength())
            .isDexterity(throwsFromDb.getIsDexterity())
            .isConstitution(throwsFromDb.getIsConstitution())
            .isIntelligence(throwsFromDb.getIsIntelligence())
            .isWisdom(throwsFromDb.getIsWisdom())
            .isCharisma(throwsFromDb.getIsCharisma())
            .build();
    }
    
}
