package com.dragon.dungeon.dao;

import org.springframework.stereotype.Component;

import com.dragon.dungeon.dto.models.characterModels.InventoryModel;
import com.dragon.dungeon.entities.character.InventoryEntity;
import com.dragon.dungeon.repositories.character.InventoryRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InventoryDao {

    private final InventoryRepo inventoryRepo;

    public InventoryEntity saveEntity(InventoryModel inventory){

        return inventoryRepo.save(InventoryEntity.builder()
                .plat(inventory.getPlat())
                .gold(inventory.getGold())
                .silver(inventory.getSilver())
                .copper(inventory.getCopper())
                .content(inventory.getContent())
        .build());
    }
    
}
