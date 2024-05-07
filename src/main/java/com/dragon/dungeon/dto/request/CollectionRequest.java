package com.dragon.dungeon.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CollectionRequest {

    private String uMail;

    @JsonCreator
    public CollectionRequest(@JsonProperty("uMail") String uMail){
        this.uMail = uMail;
    }
    
}
