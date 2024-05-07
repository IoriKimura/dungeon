package com.dragon.dungeon.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.dungeon.dto.models.MapModel;
import com.dragon.dungeon.dto.request.CreateMapRequest;
import com.dragon.dungeon.dto.response.MapCollectionResponse;
import com.dragon.dungeon.services.map.MapService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/maps")
public class MapController {

    private final MapService mapService;
    
    @PostMapping("/create")
    public MapModel createMap(@RequestBody CreateMapRequest request, @AuthenticationPrincipal String uMail){

        return mapService.create(request, uMail);
    }

    @GetMapping("")
    public ResponseEntity<MapCollectionResponse> getMapCollection(@AuthenticationPrincipal String uMail){
        MapCollectionResponse collection = mapService.getCollection(uMail);
        if (collection.getCollection() == null)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        else
            return ResponseEntity.status(HttpStatus.FOUND).body(collection);
    }
    
}
