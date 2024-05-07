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
public class UserListModel {

    private String uMail;

    private String uName;

    public static UserListModel fromEntity(UserEntity user){
        return UserListModel.builder().uMail(user.getUMail()).uName(user.getUName()).build();
    }
    
}
