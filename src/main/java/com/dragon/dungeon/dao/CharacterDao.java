package com.dragon.dungeon.dao;

import org.springframework.stereotype.Component;

import com.dragon.dungeon.dto.models.characterModels.CharacterModel;
import com.dragon.dungeon.entities.UserEntity;
import com.dragon.dungeon.entities.character.CharacterEntity;
import com.dragon.dungeon.repositories.character.CharacterRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CharacterDao {
    
    private final CharacterRepo characterRepo;

    // ToDo: Надо сделать модель под персонажа, в которую будут передаваться данные. 
    // Получение персонажа

    public CharacterModel saveCharacter(CharacterEntity character){
        
        // CharacterEntity newCharacter = CharacterEntity.builder()
        //         .owner(character.getOwner())
        //         .stats(character.getStats())
        //         .sThrows(character.getSThrows())
        //         .skills(character.getSkills())
        //         .inventory(character.getInventory())
        //         .attackId(character.getAttack())
        //         .featuresId(character.getFeatures())
        //         .cName(character.getCName())
        //         .cRace(character.getCRace())
        //         .cClass(character.getCClass())
        //         .background(character.getBackground())
        //         .level(character.getLevel())
        //         .build();
        
        return CharacterModel.fromEntity(characterRepo.save(character));
    }
}
