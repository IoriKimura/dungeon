package com.dragon.dungeon.dto.response;

import java.util.List;

import com.dragon.dungeon.dto.models.UserListModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserListResponse {

    private final List<UserListModel> users;
    
}
