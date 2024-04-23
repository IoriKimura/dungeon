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

    private boolean isStrength;
    
    private boolean isDexterity;

    private boolean isConstitution;

    private boolean isIntelligence;

    private boolean isWisdom;

    private boolean isCharisma;

    public static ThrowsModel fromEntity(SavingThrowsEntity throwsFromDb){
        
        return ThrowsModel.builder()
            .id(throwsFromDb.getId())
            .isStrength(throwsFromDb.isStrength())
            .isDexterity(throwsFromDb.isDexterity())
            .isConstitution(throwsFromDb.isConstitution())
            .isIntelligence(throwsFromDb.isIntelligence())
            .isWisdom(throwsFromDb.isWisdom())
            .isCharisma(throwsFromDb.isCharisma())
            .build();
    }
    
}
