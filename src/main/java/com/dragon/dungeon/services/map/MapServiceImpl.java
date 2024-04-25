package com.dragon.dungeon.services.map;

import org.springframework.stereotype.Service;

import com.dragon.dungeon.dao.MapsDao;
import com.dragon.dungeon.dto.models.MapModel;
import com.dragon.dungeon.dto.request.CreateMapRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MapServiceImpl implements MapService{

    private final MapsDao mapsDao;

    @Override
    public MapModel create(CreateMapRequest request) {
        return mapsDao.create(request);
    }
    
}
