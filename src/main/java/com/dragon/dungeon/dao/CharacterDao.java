package com.dragon.dungeon.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Component;

import com.dragon.dungeon.dto.models.CollectionModel;
import com.dragon.dungeon.dto.models.UserModel;
import com.dragon.dungeon.dto.models.characterModels.CharacterModel;
import com.dragon.dungeon.entities.character.CharacterEntity;
import com.dragon.dungeon.repositories.UserRepo;
import com.dragon.dungeon.repositories.character.CharacterRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CharacterDao {
    
    private final CharacterRepo characterRepo;

    private final UserRepo userRepo;

    // ToDo: Надо сделать модель под персонажа, в которую будут передаваться данные. 
    // Получение персонажа

    public CharacterModel saveCharacter(CharacterEntity character){
        
        return CharacterModel.fromEntity(characterRepo.save(character));
    }

    public List<CollectionModel> getCollection(String uMail){

        List<CharacterEntity> characterEntities = characterRepo.findByOwner(userRepo.findByuMail(uMail).get());
        List<CollectionModel> collection = new ArrayList<>();
        for(int i = 0; i < characterEntities.size(); i++){
            collection.add(CollectionModel.fromEntity(characterEntities.get(i)));
        }
        return collection;
        
    }

}
