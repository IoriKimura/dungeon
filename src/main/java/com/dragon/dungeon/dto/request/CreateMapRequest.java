package com.dragon.dungeon.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateMapRequest {

    private String data;

    @JsonCreator
    public CreateMapRequest(@JsonProperty("data") String data){
        this.data = data;
    }
}
