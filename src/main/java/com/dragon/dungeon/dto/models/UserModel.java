package com.dragon.dungeon.dto.models;

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

    private String uName;

    private String uMail;

    private String uPwd;

    public static UserModel fromEntity(UserEntity user){
        return UserModel.builder()
            .uName(user.getUName())
            .uMail(user.getUMail())
            .uPwd(user.getUPwd())
            .build();
    }
    
}
