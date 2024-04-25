package com.dragon.dungeon.services;

import com.dragon.dungeon.dto.request.RegisterRequest;
import com.dragon.dungeon.dto.response.RegisterResponse;

public interface AuthService {

    RegisterResponse register(RegisterRequest request);
}
