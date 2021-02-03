package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
    private final int ID;
    private final String text;

    public Message(@JsonProperty("ID") int ID,@JsonProperty("text") String text) {
        this.ID = ID;
        this.text = text;
    }

    public int getID() {
        return ID;
    }

    public String getText() {
        return text;
    }
}
