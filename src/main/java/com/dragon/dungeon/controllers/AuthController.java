package com.dragon.dungeon.controllers;

import javax.security.auth.login.CredentialException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.dungeon.dto.request.LoginRequest;
import com.dragon.dungeon.dto.request.RegisterRequest;
import com.dragon.dungeon.dto.response.LoginResponse;
import com.dragon.dungeon.dto.response.RegisterResponse;
import com.dragon.dungeon.services.AuthService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/auth")
public class AuthController {
    
    private final AuthService authService ;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request,
                               HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws CredentialException{
        LoginResponse response = authService.login(request, httpServletRequest, httpServletResponse);
        httpServletResponse.addCookie(new Cookie("jwt", response.getToken()));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    


}
