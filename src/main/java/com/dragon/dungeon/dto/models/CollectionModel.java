package com.dragon.dungeon.dto.models;

import java.util.UUID;

import com.dragon.dungeon.entities.character.CharacterEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CollectionModel {

    private UUID id;

    private String cName;

    private String cRace;

    private String cClass;

    private int level;

    public static CollectionModel fromEntity(CharacterEntity character){
        return CollectionModel.builder()
            .id(character.getId())
            .cName(character.getCName())
            .cRace(character.getCRace())
            .cClass(character.getCClass())
            .level(character.getLevel())
            .build();
    }
    
}
