package com.dragon.dungeon.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.dungeon.dto.models.GameModel;
import com.dragon.dungeon.dto.request.AddPlayerRequest;
import com.dragon.dungeon.dto.request.CreateGameRequest;
import com.dragon.dungeon.dto.response.CollectionResponse;
import com.dragon.dungeon.dto.response.CreateGameResponse;
import com.dragon.dungeon.dto.response.GameCollectionResponse;
import com.dragon.dungeon.dto.response.GameResponse;
import com.dragon.dungeon.services.game.GameService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/games")
public class GameController {

    private final GameService gameService;

    @PostMapping("/create")
    public ResponseEntity<CreateGameResponse> createGame(@RequestBody CreateGameRequest request, @AuthenticationPrincipal String uMail){
        return ResponseEntity.status(HttpStatus.CREATED).body(gameService.createGame(request, uMail));
    }

    @GetMapping("")
    public ResponseEntity<GameCollectionResponse> getGamesCollection(@AuthenticationPrincipal String uMail) {
        GameCollectionResponse response = gameService.getCollection(uMail);
        if(response.getGames().isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        }
        else{
            return ResponseEntity.status(HttpStatus.FOUND).body(response);
        }
       
    }

    @GetMapping("/game")
    public ResponseEntity<GameResponse> postMethodName(@RequestParam String gameId, @AuthenticationPrincipal String uMail) {
        GameResponse game = gameService.getGame(gameId, uMail);
        if(game == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(game);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(game);
    }

    @PutMapping("/game/addPlayer")
    public ResponseEntity<GameCollectionResponse> addNewPlayer(@RequestBody AddPlayerRequest request, @AuthenticationPrincipal String uMail){
        GameCollectionResponse response = gameService.updatePlayersInGame(request, uMail);
        if(response == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    
    
    
}
