package com.xperphile.userservice.controller;

import com.xperphile.userservice.constants.UserConstants;
import com.xperphile.userservice.dao.User;
import com.xperphile.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(UserConstants.USER_CONTROLLER_MAPPING)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(UserConstants.ADD_USER)
    public ResponseEntity addUser(@RequestBody Map<String, String> map){
        try{
            userService.addUser(map);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch (IllegalArgumentException exception){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(UserConstants.UPDATE_USER)
    public ResponseEntity updateUser(@RequestBody Map<String, String> map){
        try{
            userService.updateUser(map);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch (IllegalArgumentException exception){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(UserConstants.GET_USER)
    public ResponseEntity getUser(@PathVariable(name = "id") String id){
        try{
            User user = userService.getUser(id);
            return new ResponseEntity(user, HttpStatus.ACCEPTED);
        }
        catch (IllegalArgumentException exception){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(UserConstants.SEARCH_USERS)
    public ResponseEntity searchUsersByUsername(@PathVariable(name = "search_name") String search_name){
        try{
            List<User> users = userService.searchUsersByUsername(search_name);
            return new ResponseEntity(users, HttpStatus.ACCEPTED);
        }
        catch (IllegalArgumentException exception){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(UserConstants.REMOVE_USER)
    public ResponseEntity removeUser(@PathVariable("id") String id){
        try{
            userService.removeUser(id);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch (IllegalArgumentException exception){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
