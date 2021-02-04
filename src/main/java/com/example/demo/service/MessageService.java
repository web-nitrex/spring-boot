package com.example.demo.service;

import com.example.demo.models.Message;

public interface MessageService {
    Integer saveMessage(Message message);
    Message getMessage(Integer id);
}
