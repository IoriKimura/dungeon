package com.dragon.dungeon.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.dragon.dungeon.entities.UserEntity;
import com.dragon.dungeon.repositories.UserRepo;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class TestController {
    
    private final UserRepo userRepo;

    @GetMapping("")
    public List<UserEntity> getUserList(){

        return userRepo.findAll();
    } 

    @GetMapping("/info")
    public String getInfo(){
        return "THAT WORKS";
    } 
}
