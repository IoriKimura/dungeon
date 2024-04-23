package com.dragon.dungeon.dao;

import org.springframework.stereotype.Component;

import com.dragon.dungeon.dto.models.characterModels.ThrowsModel;
import com.dragon.dungeon.entities.character.SavingThrowsEntity;
import com.dragon.dungeon.repositories.character.ThrowsRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ThrowsDao {

    private final ThrowsRepo throwsRepo;

    public SavingThrowsEntity saveEntity(ThrowsModel sThrows){
        return throwsRepo.save(SavingThrowsEntity.builder()
                .isStrength(sThrows.isStrength())
                .isDexterity(sThrows.isDexterity())
                .isConstitution(sThrows.isConstitution())
                .isIntelligence(sThrows.isIntelligence())
                .isWisdom(sThrows.isWisdom())
                .isCharisma(sThrows.isCharisma())
            .build());
    }
}
