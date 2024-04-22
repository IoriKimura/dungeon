package com.dragon.dungeon.dto.request;

import com.dragon.dungeon.dto.models.characterModels.ASModel;
import com.dragon.dungeon.dto.models.characterModels.FeaturesModel;
import com.dragon.dungeon.dto.models.characterModels.InventoryModel;
import com.dragon.dungeon.dto.models.characterModels.SkillsModel;
import com.dragon.dungeon.dto.models.characterModels.StatsModel;
import com.dragon.dungeon.dto.models.characterModels.ThrowsModel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddCharacterRequest {

    private final String cName;

    private final String cRace;

    private final String cClass;

    private final String background;

    private final String level;
    
    private final StatsModel stats;

    private final ThrowsModel sThrows;

    private final SkillsModel skills;

    private final InventoryModel inventory;

    private final ASModel attack;

    private final FeaturesModel features;
    
}
