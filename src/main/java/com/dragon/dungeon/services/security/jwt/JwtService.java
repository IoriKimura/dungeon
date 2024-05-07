package com.dragon.dungeon.services.security.jwt;

import com.dragon.dungeon.dto.models.UserModel;

public interface JwtService {

    UserModel parseToken(String jwtToken);

    String generateToken(UserModel user);
}
