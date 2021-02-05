package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Message implements Serializable {
    private  int id;
    private  String text;

    public static final long SerialVersionUID = 1L;

    public Message(int id,String text) {
        this.id = id;
        this.text = text;
    }

    public int getID() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setID(int ID) {
        this.id = id;
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
