package com.dragon.dungeon.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.dragon.dungeon.dto.models.UserModel;
import com.dragon.dungeon.entities.UserEntity;
import com.dragon.repositories.UserRepo;


import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class TestController {
    
    private final UserRepo userRepo;

    @GetMapping("")
    public UserEntity getUserList(){

        return userRepo.findAll().get(0);
    } 

    @GetMapping("/info")
    public String getInfo(){
        return "THAT WORKS";
    } 
}
