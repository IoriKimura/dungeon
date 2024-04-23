package com.dragon.dungeon.dao;

import org.springframework.stereotype.Component;

import com.dragon.dungeon.dto.models.UserModel;
import com.dragon.dungeon.entities.UserEntity;
import com.dragon.dungeon.repositories.UserRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserDao {
    
    private final UserRepo userRepo;

    public UserModel getUserByEmail(String email){
        if(userRepo.findByuMail(email).isPresent())
            return UserModel.fromEntity(userRepo.findByuMail(email).get());
        return null;
    }

    public UserModel registerUser(UserModel userModel){
        UserEntity user = UserEntity.builder()
                .uName(userModel.getUName())
                .uMail(userModel.getUMail())
                .uPwd(userModel.getUPwd())
                .build();
        return UserModel.fromEntity(userRepo.save(user));
    }

    public UserEntity getUserEntityByEmail(String uMail){
        return userRepo.findByuMail(uMail).orElseThrow();
    }



}
