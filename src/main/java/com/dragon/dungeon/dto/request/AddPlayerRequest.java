package com.dragon.dungeon.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddPlayerRequest {
    
    private final String uMail;

    private final String gameId;
    
}
