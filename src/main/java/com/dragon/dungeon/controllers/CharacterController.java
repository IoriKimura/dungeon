package com.dragon.dungeon.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.dungeon.entities.character.CharacterEntity;
import com.dragon.repositories.character.CharacterRepo;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/collection")
public class CharacterController {

    private CharacterService CharacterService;

    private CharacterRepo characterRepo;

    @GetMapping("")
    public CharacterEntity getAllCharacters(){
        return characterRepo.findAll().get(0);
    }
    
}
