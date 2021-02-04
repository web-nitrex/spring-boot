package com.example.demo.service;

import com.example.demo.dao.MessageDAO;
import com.example.demo.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("localMessageService")
public class LocalMessageService implements MessageService{

    private final MessageDAO messageDAO;

    @Autowired
    public LocalMessageService(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    @Override
    public Integer saveMessage(Message message) {
        return messageDAO.addMessage(message);
    }

    @Override
    public Message getMessage(Integer id) {
        return messageDAO.getMessage(id);
    }
}
