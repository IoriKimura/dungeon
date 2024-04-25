package com.dragon.dungeon.services.character;

import com.dragon.dungeon.dto.models.characterModels.CharacterModel;
import com.dragon.dungeon.dto.request.AddCharacterRequest;
import com.dragon.dungeon.dto.request.CollectionRequest;
import com.dragon.dungeon.dto.response.CollectionResponse;

public interface CharacterService {

    CharacterModel create(AddCharacterRequest request);

    CollectionResponse getCollection(CollectionRequest request);

    CharacterModel getCharacter(String uMail, String cId);
    
}
