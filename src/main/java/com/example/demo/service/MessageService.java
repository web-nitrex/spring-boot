package com.example.demo.service;

import com.example.demo.models.Message;

public interface MessageService {
    Integer saveMessage(String message);
    String getMessage(Integer id);
}
