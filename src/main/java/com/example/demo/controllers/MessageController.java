package com.example.demo.controllers;

import com.example.demo.models.Message;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(@Qualifier("testMessageService") MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public ResponseEntity saveMessage(@RequestBody Message message)
    {
        if(message.getText().equals("")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else {
            Integer id = messageService.saveMessage(message);
            return ResponseEntity.ok(new Message(id,""));
        }
    }

    @GetMapping("get-message")
    public ResponseEntity getMessage(@RequestBody Message message)
    {
        Message messageFromDAO = messageService.getMessage(message.getID());

        if(messageFromDAO==null)
            return ResponseEntity.badRequest().body("");
        else
            return ResponseEntity.ok(new Message(0,messageFromDAO.getText()));
    }
}
