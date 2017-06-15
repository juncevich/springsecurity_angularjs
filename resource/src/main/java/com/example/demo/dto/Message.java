package com.example.demo.dto;

import java.util.UUID;

/**
 * Sample message DTO
 * 
 * Created by juncevich on 6/15/17.
 */
public class Message {

    private String id = UUID.randomUUID().toString();

    private String content;

    public Message(String content) {
        this.content = content;
    }

    /**
     * @return the {@link #id}
     */
    public String getId() {

        return id;
    }

    /**
     * @param id
     *            the {@link #id} to set
     */
    public void setId(String id) {

        this.id = id;
    }

    /**
     * @return the {@link #content}
     */
    public String getContent() {

        return content;
    }

    /**
     * @param content
     *            the {@link #content} to set
     */
    public void setContent(String content) {

        this.content = content;
    }
}
