package com.dragon.dungeon.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CreateGameRequest {

    private String mapId;

     @JsonCreator
    public CreateGameRequest(@JsonProperty("mapId") String mapId){
        this.mapId = mapId;
    }
}
