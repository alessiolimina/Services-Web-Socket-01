package it.develhope.websocket.Services.Web.Socket1.controller;

import it.develhope.websocket.Services.Web.Socket1.entities.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class NotificationController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/notification")
    public ResponseEntity sendNotificationToClients(@RequestBody MessageDTO messageDTO){
    simpMessagingTemplate.convertAndSend("/topic/broadcast-messages", messageDTO);
    return ResponseEntity.status(HttpStatus.OK).build();
    }
}
//Documentazione Postman: https://documenter.getpostman.com/view/26121086/2s93eeQpEV