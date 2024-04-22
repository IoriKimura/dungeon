package com.dragon.dungeon.dto.models.characterModels;


import java.util.UUID;

import com.dragon.dungeon.entities.character.InventoryEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryModel {

    private UUID id;

    private int plat;

    private int gold;

    private int silver;
    
    private int copper;

    private String content;

    public static InventoryModel fromEntity(InventoryEntity inventory){
        
        return InventoryModel.builder()
            .id(inventory.getId())
            .plat(inventory.getPlat())
            .gold(inventory.getGold())
            .silver(inventory.getSilver())
            .copper(inventory.getCopper())
            .content(inventory.getContent())
            .build();
    }
    
}
