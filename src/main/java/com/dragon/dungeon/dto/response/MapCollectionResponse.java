package com.dragon.dungeon.dto.response;

import java.util.List;

import com.dragon.dungeon.dto.models.MapModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MapCollectionResponse {

    private List<MapModel> collection;
    
}
