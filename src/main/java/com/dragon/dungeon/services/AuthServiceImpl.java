package com.dragon.dungeon.services;

import org.springframework.stereotype.Service;

import com.dragon.dungeon.dao.UserDao;
import com.dragon.dungeon.dto.models.UserModel;
import com.dragon.dungeon.dto.request.RegisterRequest;
import com.dragon.dungeon.dto.response.RegisterResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    
    private final UserDao userDao;


    @Override
    public RegisterResponse register(RegisterRequest request) {
        if(userDao.getUserByEmail(request.getUMail()) != null){
            throw new RuntimeException("This email is already taken");
        }

        UserModel newUser = UserModel.builder()
                .uName(request.getUName())
                .uMail(request.getUMail())
                .uPwd(request.getUPwd())
                .build();
        UserModel savedUser = userDao.registerUser(newUser);

        return RegisterResponse.builder()
            .id(savedUser.getId())
            .uMail(savedUser.getUMail())
        .build();
    }

}


