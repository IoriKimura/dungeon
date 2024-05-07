package com.dragon.dungeon.dto.models.characterModels;

import java.util.UUID;

import com.dragon.dungeon.entities.character.CharacterEntity;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterModel {

    private UUID id;
    
    private StatsModel stats;

    private ThrowsModel sThrows;

    private SkillsModel skills;

    private InventoryModel inventory;

    private ASModel attack;

    private FeaturesModel features;

    private String cName;

    private String cRace;

    private String cClass;

    private String background;

    private int level;

    public static CharacterModel fromEntity(CharacterEntity character){
        return CharacterModel.builder()
                .id(character.getId())
                .stats(StatsModel.fromEntity(character.getStats()))
                .sThrows(ThrowsModel.fromEntity(character.getSThrows()))
                .skills(SkillsModel.fromEntity(character.getSkills()))
                .inventory(InventoryModel.fromEntity(character.getInventory()))
                .attack(ASModel.fromEntity(character.getAttack()))
                .features(FeaturesModel.fromEntity(character.getFeatures()))
                .cName(character.getCName())
                .cRace(character.getCRace())
                .cClass(character.getCClass())
                .background(character.getBackground())
                .level(character.getLevel())
            .build();
    }
}
