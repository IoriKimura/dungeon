package com.dragon.dungeon.controllers;

import org.springframework.web.bind.annotation.RestController;

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
    public String getUserList(){
        return userRepo.findAll().toString();
    } 

    @GetMapping("/info")
    public String getInfo(){
        return "THAT WORKS";
    } 
}
