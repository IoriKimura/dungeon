package com.dragon.dungeon.services.stats;

import com.dragon.dungeon.dto.request.AddCharacterRequest;
import com.dragon.dungeon.entities.character.StatsEntity;

public interface StatsService {
    
    StatsEntity createStatsEntity(AddCharacterRequest request);
}
