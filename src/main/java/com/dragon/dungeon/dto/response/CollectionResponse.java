package com.dragon.dungeon.dto.response;

import java.util.List;

import com.dragon.dungeon.dto.models.CollectionModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CollectionResponse {

    private List<CollectionModel> collection;
}
