package com.dragon.dungeon.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.dungeon.dto.models.GameModel;
import com.dragon.dungeon.dto.request.CreateGameRequest;
import com.dragon.dungeon.services.game.GameService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/games")
public class GameController {

    private final GameService gameService;

    @PostMapping("/create")
    public GameModel createGame(@RequestBody CreateGameRequest request){
        return gameService.createGame(request);
    }
    
}
