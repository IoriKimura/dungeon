package com.dragon.dungeon.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.dungeon.dto.models.characterModels.CharacterModel;
import com.dragon.dungeon.dto.request.AddCharacterRequest;
import com.dragon.dungeon.dto.request.CollectionRequest;
import com.dragon.dungeon.dto.response.CollectionResponse;
import com.dragon.dungeon.services.character.CharacterService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/collection")
public class CharacterController {

    private final CharacterService characterService;
    
    @PostMapping("")
    public ResponseEntity<CollectionResponse> getAllCharacters(@RequestBody CollectionRequest request){
        return ResponseEntity.status(HttpStatus.FOUND).body(characterService.getCollection(request));
    }

    @PostMapping("/create")
    public ResponseEntity<CharacterModel> createCharacter(@RequestBody AddCharacterRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(characterService.create(request));
    }

    @GetMapping("/character")
    public ResponseEntity<CharacterModel> getCharacter(@RequestParam String uMail, @RequestParam String cId){
        CharacterModel character = characterService.getCharacter(uMail, cId);
        if (character != null)
            return ResponseEntity.status(HttpStatus.FOUND).body(character);
        else
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(character);

    }
    
}
