package com.dragon.dungeon.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.dragon.dungeon.dto.models.UserListModel;
import com.dragon.dungeon.dto.response.UserListResponse;
import com.dragon.dungeon.entities.UserEntity;
import com.dragon.dungeon.repositories.UserRepo;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class TestController {
    
    private final UserRepo userRepo;

    @GetMapping("")
    public UserListResponse getUserList(){
        List<UserEntity> users = userRepo.findAll();
        List<UserListModel> userModels = new ArrayList<>();
        for (UserEntity user : users){
            userModels.add(UserListModel.fromEntity(user));
        }
        return UserListResponse.builder().users(userModels).build();
    } 

    @GetMapping("/info")
    public String getInfo(){
        return "THAT WORKS";
    } 
}
