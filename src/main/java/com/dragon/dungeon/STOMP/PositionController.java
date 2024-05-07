package com.dragon.dungeon.STOMP;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@Transactional
public class PositionController {

  @MessageMapping("/{gameId}")
  @SendTo("/topic/{gameId}")
  public ChangePsoitionResponse changePosition(ChangePositionRequest request) throws Exception {
    return ChangePsoitionResponse.builder().id(request.getId()).posX(request.getPosX()).posY(request.getPosY()).build();
  }

}
