package com.dragon.dungeon.dao.character;

import org.springframework.stereotype.Component;

import com.dragon.dungeon.dto.models.characterModels.FeaturesModel;
import com.dragon.dungeon.entities.character.FeaturesEntity;
import com.dragon.dungeon.repositories.character.FeaturesRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FeaturesDao {

    private final FeaturesRepo featuresRepo;

    public FeaturesEntity saveEntity(FeaturesModel features){
        return featuresRepo.save(FeaturesEntity.builder()
                .feature(features.getFeature())
            .build());
    }
    
}
