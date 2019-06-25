package com.xperphile.userservice.controller;

import com.xperphile.userservice.constants.UserConstants;
import com.xperphile.userservice.dao.User;
import com.xperphile.userservice.dao.UserFav;
import com.xperphile.userservice.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Component
@RestController
@RequestMapping(UserConstants.USER_MGMT_CONTROLLER_MAPPING)
public class UserManagementController {

    @Autowired
    private UserManagementService userManagementService;

    @PostMapping(UserConstants.FOLLOW_USER)
    public ResponseEntity follow(@RequestBody Map<String, String> map){
        try{
            userManagementService.follow(map);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch (IllegalArgumentException exception){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(UserConstants.UNFOLLOW_USER)
    public ResponseEntity unfollow(@PathVariable("id") String id){
        try{
            userManagementService.unfollow(id);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch (IllegalArgumentException exception){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(UserConstants.GET_FOLLOWERS)
    public ResponseEntity getFollowers(@PathVariable("user_id") String user_id){
        try{
            List<User> users = userManagementService.getFollowers(user_id);
            return new ResponseEntity(users, HttpStatus.ACCEPTED);
        }
        catch (IllegalArgumentException exception){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(UserConstants.GET_FOLLOWINGS)
    public ResponseEntity getFollowings(@PathVariable("follower_id") String follower_id){
        try{
            List<User> followings = userManagementService.getFollowings(follower_id);
            return new ResponseEntity(followings, HttpStatus.ACCEPTED);
        }
        catch (IllegalArgumentException exception){
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
    }

    @PostMapping(UserConstants.BLOCK_USER)
    public ResponseEntity block(@PathVariable("user_id") String user_id, @PathVariable("blocked_id") String blocked_id){
        try{
            userManagementService.block(user_id, blocked_id);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch (IllegalArgumentException exception){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(UserConstants.UNBLOCK_USER)
    public ResponseEntity unblock(@PathVariable("id") String id){
        try{
            userManagementService.unblock(id);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch (IllegalArgumentException exception){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(UserConstants.GET_BLOCKED_USERS)
    public ResponseEntity getBlockedUser(@PathVariable("user_id") String user_id){
        try{
            List<User> blockedUsers = userManagementService.getBlockedUsers(user_id);
            return new ResponseEntity(blockedUsers, HttpStatus.ACCEPTED);
        }
        catch (IllegalArgumentException exception){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(UserConstants.ADD_USER_FAV)
    public ResponseEntity addFav(@RequestBody Map<String, String> map){
        try{
            userManagementService.addFav(map);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch (IllegalArgumentException exception){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(UserConstants.REMOVE_USER_FAV)
    public ResponseEntity remFav(@RequestBody Map<String, String> map){
        try {
            userManagementService.remFav(map);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch (IllegalArgumentException exception){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(UserConstants.GET_USER_FAVS)
    public ResponseEntity getUserFavs(@PathVariable("user_id") String user_id){
        try{
            UserFav userFavList = userManagementService.getUserFavs(user_id);
            return new ResponseEntity(userFavList, HttpStatus.ACCEPTED);
        }
        catch (IllegalArgumentException exception){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
