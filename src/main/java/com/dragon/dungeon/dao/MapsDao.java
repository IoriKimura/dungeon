package com.dragon.dungeon.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.dragon.dungeon.dto.models.MapModel;
import com.dragon.dungeon.dto.request.CreateMapRequest;
import com.dragon.dungeon.entities.MapEntity;
import com.dragon.dungeon.entities.UserEntity;
import com.dragon.dungeon.repositories.MapsRepo;
import com.dragon.dungeon.repositories.UserRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MapsDao {
    
    private final MapsRepo mapsRepo;
    private final UserRepo userRepo;

    public MapModel create(CreateMapRequest request, String uMail){
        try {
            UUID id = UUID.randomUUID();
            UserEntity user = userRepo.findByuMail(uMail).orElseThrow();
            String jsonString = "{\"data\": \"" + request.getData() + "\"}";
            
            MapEntity map = MapEntity.builder()
                .id(id)
                .ownerId(user)
                .data(jsonString)
                .build();

            
            map = mapsRepo.saveMapAndReturn(map.getId(), map.getOwnerId().getUserId(), map.getData());
            return MapModel.fromEntity(map);
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


    public List<MapModel> getCollection(String uMail) {
        try {
            List<MapEntity> mapEntities = mapsRepo.findByOwnerId(userRepo.findByuMail(uMail).get());
            List<MapModel> collection = new ArrayList<>();
            for(int i = 0; i < mapEntities.size(); i++){
                collection.add(MapModel.fromEntity(mapEntities.get(i)));
            }
            return collection;
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
