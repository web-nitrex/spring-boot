package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Message implements Serializable {
    private  int ID;
    private  String text;

    public static final long SerialVersionUID = 1L;

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

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setText(String text) {
        this.text = text;
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
