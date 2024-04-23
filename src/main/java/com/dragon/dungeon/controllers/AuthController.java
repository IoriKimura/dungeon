package com.dragon.dungeon.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.dungeon.dto.models.UserModel;
import com.dragon.dungeon.dto.request.RegisterRequest;
import com.dragon.dungeon.services.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/auth")
public class AuthController {
    
    private final AuthService authService ;

    @PostMapping("/register")
    public UserModel register(@RequestBody RegisterRequest request){
        return authService.register(request);
    }


}
