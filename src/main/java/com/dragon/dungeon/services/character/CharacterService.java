package com.dragon.dungeon.services.character;

import com.dragon.dungeon.dto.models.characterModels.CharacterModel;
import com.dragon.dungeon.dto.request.AddCharacterRequest;

public interface CharacterService {

    CharacterModel create(AddCharacterRequest request);
    
}
