package com.example.demo.service;

import com.example.demo.dao.MessageDAO;
import com.example.demo.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("local")
@Service
public class LocalMessageService implements MessageService{

    private final MessageDAO messageDAO;

    @Value("${test.my.value}")
    private  String valueSetting;

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

    @Override
    public String getValueSetting() {
        return valueSetting;
    }
}
