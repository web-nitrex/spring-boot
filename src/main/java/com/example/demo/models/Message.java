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

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("id: " + this.getID() +" ");
        sb.append("text :" + this.getText() +"\n");
        return sb.toString();
    }
}
