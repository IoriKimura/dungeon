package com.dragon.dungeon.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.dungeon.dto.models.MapModel;
import com.dragon.dungeon.dto.request.CreateMapRequest;
import com.dragon.dungeon.services.map.MapService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/maps")
public class MapController {

    private final MapService mapService;
    
    @PostMapping("/create")
    public MapModel createMap(@RequestBody CreateMapRequest request){

        return mapService.create(request);
    }
    
}
