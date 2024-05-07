package com.dragon.dungeon.services.map;

import org.springframework.stereotype.Service;

import com.dragon.dungeon.dao.MapsDao;
import com.dragon.dungeon.dto.models.MapModel;
import com.dragon.dungeon.dto.request.CreateMapRequest;
import com.dragon.dungeon.dto.response.MapCollectionResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MapServiceImpl implements MapService{

    private final MapsDao mapsDao;

    @Override
    public MapModel create(CreateMapRequest request, String uMail) {
        return mapsDao.create(request, uMail);
    }

    @Override
    public MapCollectionResponse getCollection(String uMail) {
        return MapCollectionResponse.builder()
        .collection(mapsDao.getCollection(uMail))
        .build();
    }
    
}
