package com.dragon.dungeon.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.dungeon.dto.models.characterModels.CharacterModel;
import com.dragon.dungeon.dto.request.AddCharacterRequest;
import com.dragon.dungeon.dto.response.CollectionResponse;
import com.dragon.dungeon.services.character.CharacterService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/collection")
public class CharacterController {

    private final CharacterService characterService;
    
    @GetMapping("")
    public ResponseEntity<CollectionResponse> getAllCharacters(@AuthenticationPrincipal String uMail){
        CollectionResponse response = characterService.getCollection(uMail);
        if(response.getCollection().isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        else{
            return ResponseEntity.status(HttpStatus.FOUND).body(response);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<CharacterModel> createCharacter(@RequestBody AddCharacterRequest request, @AuthenticationPrincipal String uMail){
        return ResponseEntity.status(HttpStatus.CREATED).body(characterService.create(request, uMail)); 
    }

    @GetMapping("/character")
    public ResponseEntity<CharacterModel> getCharacter(@RequestParam String cId, @AuthenticationPrincipal String uMail){
        try {
            CharacterModel character = characterService.getCharacter(uMail, cId);
            if (character != null)
                return ResponseEntity.status(HttpStatus.FOUND).body(character);
            else
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(character);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
}
