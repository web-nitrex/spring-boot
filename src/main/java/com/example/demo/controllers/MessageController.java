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
    public MessageController(@Qualifier("localMessageService") MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public ResponseEntity saveMessage(@RequestBody Message message)
    {
        if(message.getText().equals("")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else {
            System.out.println(message.getID());
            System.out.println(message.getText());
            Integer id = messageService.saveMessage(message.getText());
            return new ResponseEntity<>(id,HttpStatus.OK);
        }

    }

    @GetMapping("get-message")
    public ResponseEntity getMessage(@RequestBody Message message)
    {
        String result = messageService.getMessage(message.getID());

        System.out.println(message.getID());
        System.out.println(message.getText());

        if(result==null)
            return new ResponseEntity<>("",HttpStatus.OK);
        else
            return new ResponseEntity(result, HttpStatus.OK);
    }
}
