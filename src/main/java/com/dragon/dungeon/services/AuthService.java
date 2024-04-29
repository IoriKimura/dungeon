package com.dragon.dungeon.services;

import javax.security.auth.login.CredentialException;

import com.dragon.dungeon.dto.request.LoginRequest;
import com.dragon.dungeon.dto.request.RegisterRequest;
import com.dragon.dungeon.dto.response.LoginResponse;
import com.dragon.dungeon.dto.response.RegisterResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {

    RegisterResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) throws CredentialException;
}
