package com.dragon.dungeon.services.map;

import com.dragon.dungeon.dto.models.MapModel;
import com.dragon.dungeon.dto.request.CreateMapRequest;

public interface MapService {

    MapModel create(CreateMapRequest request);
    
} 
