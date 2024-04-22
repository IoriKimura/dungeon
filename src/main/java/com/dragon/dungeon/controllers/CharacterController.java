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

import com.dragon.dungeon.dto.models.characterModels.CharacterModel;
import com.dragon.dungeon.dto.request.AddCharacterRequest;
import com.dragon.dungeon.entities.character.CharacterEntity;
import com.dragon.repositories.character.CharacterRepo;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/collection")
public class CharacterController {

    private CharacterService characterService;

    private CharacterRepo characterRepo;

    @GetMapping("")
    public CharacterEntity getAllCharacters(){
        return characterRepo.findAll().get(0);
    }

    @PostMapping("/create")
    public CharacterModel createCharacter(@RequestBody AddCharacterRequest request){

        return characterService.create(request);
    }
    
}
