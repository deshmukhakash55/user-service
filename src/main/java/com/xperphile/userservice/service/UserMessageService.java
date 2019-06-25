package com.xperphile.userservice.service;

import com.xperphile.userservice.dao.UserMessages;
import com.xperphile.userservice.repository.UserMessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Component
public class UserMessageService {

    @Autowired
    private UserMessagesRepository userMessagesRepository;

    public void addMessage(Map<String, String> map) throws IllegalArgumentException{
        String user_id = map.get("user_id");
        String messager_id = map.get("messager_id");
        String message = map.get("message");
        String referred_message = map.get("referred_message");
        if(user_id == null || user_id.isEmpty())
            throw new IllegalArgumentException("Illegal user_id");
        if(messager_id == null || messager_id.isEmpty())
            throw new IllegalArgumentException("Illegal message_id");
        if(message == null || message.isEmpty())
            throw new IllegalArgumentException("Illegal message");
        if(referred_message == null || referred_message.isEmpty())
            throw new IllegalArgumentException("Illegal referred_message");
        String id = UUID.randomUUID().toString();
        Timestamp creation_time = new Timestamp(new Date().getTime());
        String status = "unread";
        UserMessages userMessages = new UserMessages(id, user_id, messager_id, message, creation_time, null, referred_message, status);
        userMessagesRepository.save(userMessages);

        /*
            Notify the user with message
         */


    }

}
