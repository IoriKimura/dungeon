package com.dragon.dungeon.dao.character;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.dragon.dungeon.dto.models.CollectionModel;
import com.dragon.dungeon.dto.models.characterModels.CharacterModel;
import com.dragon.dungeon.entities.UserEntity;
import com.dragon.dungeon.entities.character.CharacterEntity;
import com.dragon.dungeon.repositories.UserRepo;
import com.dragon.dungeon.repositories.character.CharacterRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CharacterDao {
    
    private final CharacterRepo characterRepo;

    private final UserRepo userRepo;

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

    public CharacterModel getCharacter(UserEntity user, String cId) {
        CharacterEntity characterEntity = characterRepo.getReferenceById(UUID.fromString(cId));
        if (user.equals(characterEntity.getOwner())){
            return CharacterModel.fromEntity(characterRepo.getReferenceById(UUID.fromString(cId)));
        }
        else
            return null;
    }

}
