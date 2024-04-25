package com.dragon.dungeon.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.dungeon.dto.request.CreateGameRequest;
import com.dragon.dungeon.dto.response.CreateGameResponse;
import com.dragon.dungeon.services.game.GameService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/games")
public class GameController {

    private final GameService gameService;

    @PostMapping("/create")
    public ResponseEntity<CreateGameResponse> createGame(@RequestBody CreateGameRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(gameService.createGame(request));
    }
    
}
