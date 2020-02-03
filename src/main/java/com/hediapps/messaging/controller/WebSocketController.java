package com.hediapps.messaging.controller;

import com.hediapps.messaging.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class WebSocketController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/public")
    @SendTo("/topic/public")
    public MessageDto sendPublicMessage(MessageDto message) {
        return message;
    }

    @MessageMapping("/secured/room")
    public void sendPrivateMessage(@Payload MessageDto message) {
        simpMessagingTemplate.convertAndSendToUser(message.getDestination(), "/private", message);
    }
}
