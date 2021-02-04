package com.example.demo.dao;

import com.example.demo.models.Message;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Scope("prototype")
public class MessageDAO {
    private final Map<Integer,String> messageStorage = new HashMap<>();

    private static Integer idCounter = new Integer(0);

    public Integer addMessage(Message message)
    {
        Integer id = ++idCounter;
        messageStorage.put(id, message.getText());
        return id;
    }

    public Message getMessage(Integer id)
    {
        if(messageStorage.containsKey(id))
            return new Message(id, messageStorage.get(id));
        else
            return null;
    }

    public List<Message> getListMessageStorage()
    {
        List<Message> result = new ArrayList<>();
        for(Map.Entry entry : messageStorage.entrySet())
        {
            result.add(new Message((Integer) entry.getKey(),(String) entry.getValue()));
        }
        return result;
    }

}
