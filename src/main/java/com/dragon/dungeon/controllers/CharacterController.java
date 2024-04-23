package com.dragon.dungeon.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.dungeon.dao.CharacterDao;
import com.dragon.dungeon.dto.models.characterModels.CharacterModel;
import com.dragon.dungeon.dto.request.AddCharacterRequest;
import com.dragon.dungeon.entities.character.CharacterEntity;
import com.dragon.dungeon.repositories.character.CharacterRepo;
import com.dragon.dungeon.services.character.CharacterService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/collection")
public class CharacterController {

    private final CharacterService characterService;

    private final CharacterDao characterDao;

    private final CharacterRepo characterRepo;

    @GetMapping("")
    public CharacterModel getAllCharacters(){
        return CharacterModel.fromEntity(characterRepo.findAll().get(0));
    }

    @PostMapping("/create")
    public CharacterModel createCharacter(@RequestBody AddCharacterRequest request){
        return characterService.create(request);
    }
    
}
