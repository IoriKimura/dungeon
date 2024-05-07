package com.dragon.dungeon.dto.models.characterModels;


import java.util.UUID;

import com.dragon.dungeon.entities.character.FeaturesEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeaturesModel {

    private UUID id;

    private String feature;
    
    public static FeaturesModel fromEntity(FeaturesEntity features){
        
        return FeaturesModel.builder()
            .id(features.getId())
            .feature(features.getFeature())
            .build();
    }
    
}
