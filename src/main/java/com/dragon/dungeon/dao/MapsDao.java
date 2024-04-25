package com.dragon.dungeon.dao;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.hibernate.type.format.jakartajson.JsonBJsonFormatMapper;
import org.springframework.stereotype.Component;

import com.dragon.dungeon.dto.MapData;
import com.dragon.dungeon.dto.models.MapModel;
import com.dragon.dungeon.dto.request.CreateMapRequest;
import com.dragon.dungeon.entities.MapEntity;
import com.dragon.dungeon.entities.UserEntity;
import com.dragon.dungeon.repositories.MapsRepo;
import com.dragon.dungeon.repositories.UserRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MapsDao {
    
    private final MapsRepo mapsRepo;
    private final UserRepo userRepo;
    private final ObjectMapper objectMapper;


    public MapModel create(CreateMapRequest request){
        try {
            UUID id = UUID.randomUUID();
            UserEntity user = userRepo.findByuMail(request.getUMail()).orElseThrow();
            String jsonString = "{\"data\": \"" + request.getData() + "\"}";
            
            MapEntity map = MapEntity.builder()
                .id(id)
                .ownerId(user)
                .data(jsonString)
                .build();

            
            map = mapsRepo.saveMapAndReturn(map.getId(), map.getOwnerId().getUserId(), map.getData());
            JsonNode jsonNode = objectMapper.readTree(map.getData());

            // Получение значения поля "data"
            String dataValue = jsonNode.get("data").asText();
            map.setData(dataValue);
            return MapModel.fromEntity(map);
        } catch (JsonProcessingException e) {
            // Обработка ошибки при преобразовании DTO в JSON-строку
            e.printStackTrace();
            // Возможно, здесь вам нужно выбросить какое-то исключение или вернуть null
            return null;
        } catch (NoSuchElementException e) {
            // Обработка ошибки, если пользователь не найден
            e.printStackTrace();
            // Возможно, здесь вам нужно выбросить какое-то исключение или вернуть null
            return null;
        } catch (Exception e) {
            // Обработка других исключений
            e.printStackTrace();
            // Возможно, здесь вам нужно выбросить какое-то исключение или вернуть null
            return null;
        }
    }
}