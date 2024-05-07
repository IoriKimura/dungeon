package com.dragon.dungeon.services.stats;

import org.springframework.stereotype.Service;

import com.dragon.dungeon.dao.character.StatsDao;
import com.dragon.dungeon.dto.request.AddCharacterRequest;
import com.dragon.dungeon.entities.character.StatsEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {

    private final StatsDao statsDao;

    @Override
    public StatsEntity createStatsEntity(AddCharacterRequest request) {

        return statsDao.saveEntity(request.getStats());
    }
    
}
