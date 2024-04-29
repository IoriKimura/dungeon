package com.dragon.dungeon.services.map;


import java.util.UUID;

import com.dragon.dungeon.dto.models.MapModel;
import com.dragon.dungeon.dto.request.CreateMapRequest;
import com.dragon.dungeon.dto.response.MapCollectionResponse;

public interface MapService {

    MapModel create(CreateMapRequest request, String uMail);

    MapCollectionResponse getCollection(String uMail);
    
} 
