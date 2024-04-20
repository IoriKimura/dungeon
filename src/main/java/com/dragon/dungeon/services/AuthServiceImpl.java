package com.dragon.dungeon.services;

import org.springframework.stereotype.Service;

import com.dragon.dungeon.dao.UserDao;
import com.dragon.dungeon.dto.models.UserModel;
import com.dragon.dungeon.dto.request.RegisterRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    
    private final UserDao userDao;


    @Override
    public UserModel register(RegisterRequest request) {
        if(userDao.getUserByEmail(request.getUMail()) != null){
            throw new RuntimeException("This email is already taken");
        }

        UserModel newUser = UserModel.builder()
                .uName(request.getUName())
                .uMail(request.getUMail())
                .uPwd(request.getUPwd())
                .build();

        return userDao.registerUser(newUser);
    }

}


