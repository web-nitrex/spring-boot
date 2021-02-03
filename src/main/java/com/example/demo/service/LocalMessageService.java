package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service("localMessageService")
public class LocalMessageService implements MessageService{
    private final Map<Integer,String> messageStorage = new HashMap<>();
    private final Random random = new Random();

    @Override
    public Integer saveMessage(String message) {
        Integer id = random.nextInt(1000000);
        messageStorage.put(id, message);
        return id;
    }

    @Override
    public String getMessage(Integer id) {
        if(messageStorage.containsKey(id))
            return messageStorage.get(id);
        else
            return null;
    }
}
