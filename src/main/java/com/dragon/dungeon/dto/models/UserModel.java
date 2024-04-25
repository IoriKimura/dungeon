package com.dragon.dungeon.dto.models;

import java.util.UUID;

import com.dragon.dungeon.entities.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    private UUID id;

    private String uName;

    private String uMail;

    private String uPwd;

    public static UserModel fromEntity(UserEntity user){
        return UserModel.builder()
            .id(user.getUserId())
            .uName(user.getUName())
            .uMail(user.getUMail())
            .uPwd(user.getUPwd())
            .build();
    }
    
}
