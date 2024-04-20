package com.dragon.dungeon.services;

import com.dragon.dungeon.dto.models.UserModel;
import com.dragon.dungeon.dto.request.RegisterRequest;

public interface AuthService {

    UserModel register(RegisterRequest request);
}
