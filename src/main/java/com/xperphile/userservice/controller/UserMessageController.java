package com.xperphile.userservice.controller;

import com.xperphile.userservice.constants.UserConstants;
import com.xperphile.userservice.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Component
@RestController
@RequestMapping(UserConstants.USER_MSG_CONTROLLER_MAPPING)
public class UserMessageController {

    @Autowired
    private UserMessageService userMessageService;

    @PostMapping(UserConstants.ADD_MSG)
    public ResponseEntity addMessage(@RequestBody Map<String, String> map){
        try{
            userMessageService.addMessage(map);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch (IllegalArgumentException exception){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
