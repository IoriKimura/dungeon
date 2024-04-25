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

    private UserModel owner;

    private String data;


    //Добавить данные карты

    public static MapModel fromEntity(MapEntity map){
        return MapModel.builder()
            .id(map.getId())
            .owner(UserModel.fromEntity(map.getOwnerId()))
            .data(clearDataMap(map.getData()))
            .build();
    }

    private static String clearDataMap(String data){
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode jsonNode;
            try {
                jsonNode = objectMapper.readTree(data);
                String dataValue = jsonNode.get("data").asText();
                return dataValue;
            } catch (JsonProcessingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }

            // Получение значения поля "data"
    }
    
}
