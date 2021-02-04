package com.example.demo.service;

import com.example.demo.dao.MessageDAO;
import com.example.demo.models.Message;
import com.example.demo.util.MessageJsonWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("testMessageService")
public class TestMessageService implements MessageService{

    private final MessageDAO messageDAO;

    private final MessageJsonWriter jsonWriter;

    private static final Logger LOGGER = LoggerFactory.getLogger(TestMessageService.class);

    @Autowired
    public TestMessageService(MessageDAO messageDAO, MessageJsonWriter jsonWriter) {
        this.messageDAO = messageDAO;
        this.jsonWriter = jsonWriter;
    }

    @Override
    public Integer saveMessage(Message message) {
        Integer id = messageDAO.addMessage(message);
        LOGGER.info("Saved message: id={}, text:{}",id, message.getText());
        return id;
    }

    @Override
    public Message getMessage(Integer id) {
        return messageDAO.getMessage(id);
    }
}
