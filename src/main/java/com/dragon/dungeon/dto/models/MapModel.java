package com.dragon.dungeon.dto.models;

import java.util.UUID;

import com.dragon.dungeon.entities.MapEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MapModel {

    private UUID id;

    private UUID owner;

    private JsonNode data;

    public static MapModel fromEntity(MapEntity map){
        return MapModel.builder()
            .id(map.getId())
            .owner(map.getOwnerId().getUserId())
            .data(clearDataMap(map.getData()))
            .build();
    }

    private static JsonNode clearDataMap(String data){
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode jsonNode;
            try {
                jsonNode = objectMapper.readTree(data).get("data");
                return jsonNode;
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return null;
            }
    }
    
}
