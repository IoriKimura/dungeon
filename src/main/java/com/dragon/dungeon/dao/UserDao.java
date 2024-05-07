package com.dragon.dungeon.dao;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.dragon.dungeon.dto.models.UserModel;
import com.dragon.dungeon.entities.UserEntity;
import com.dragon.dungeon.repositories.UserRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserDao {
    
    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    public UserModel getUserByEmail(String email){
        if(userRepo.findByuMail(email).isPresent())
            return UserModel.fromEntity(userRepo.findByuMail(email).get());
        return null;
    }

    public UserModel registerUser(UserModel userModel){
        UserEntity user = UserEntity.builder()
                .uName(userModel.getUName())
                .uMail(userModel.getUMail())
                .uPwd(passwordEncoder.encode(userModel.getUPwd()))
                .build();
        return UserModel.fromEntity(userRepo.save(user));
    }

    public UserEntity getUserEntityByEmail(String uMail){
        return userRepo.findByuMail(uMail).orElseThrow();
    }

    public boolean userExistByEmail(String email){
        return userRepo.findByuMail(email).isPresent();
    }

    public boolean validateUser(String uMail, String uPwd) {
        UserEntity user = getUserEntityByEmail(uMail);
        return passwordEncoder.matches(uPwd, user.getUPwd());
    }
}
