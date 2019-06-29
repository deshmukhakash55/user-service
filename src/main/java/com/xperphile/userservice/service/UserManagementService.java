package com.xperphile.userservice.service;

import com.xperphile.userservice.dao.User;
import com.xperphile.userservice.dao.UserBlock;
import com.xperphile.userservice.dao.UserFav;
import com.xperphile.userservice.dao.UserFollower;
import com.xperphile.userservice.repository.UserBlockRepository;
import com.xperphile.userservice.repository.UserFavRepository;
import com.xperphile.userservice.repository.UserFollowerRepository;
import com.xperphile.userservice.utility.StringListConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.*;

@Component
public class UserManagementService {

    @Autowired
    private UserFollowerRepository userFollowerRepository;

    @Autowired
    private UserBlockRepository userBlockRepository;

    @Autowired
    private UserFavRepository userFavRepository;

    @Autowired
    private UserService userService;

    public void follow(Map<String, String> map) throws IllegalArgumentException{
        String user_id = map.get("user_id");
        String follower_id = map.get("follower_id");
        if(user_id == null || user_id.isEmpty())
            throw new IllegalArgumentException("Illegal user_id");
        if(follower_id == null || follower_id.isEmpty())
            throw new IllegalArgumentException("Illegal follower_id");
        String id = UUID.randomUUID().toString();
        Timestamp creation_date = new Timestamp(new Date().getTime());
        UserFollower userFollower = new UserFollower(id, user_id, follower_id, creation_date);
        userFollowerRepository.save(userFollower);
    }

    public void unfollow(String id) throws IllegalArgumentException{
        if(id == null || id.isEmpty())
            throw new IllegalArgumentException("Illegal id");
        userFollowerRepository.deleteById(id);
    }

    public List<User> getFollowers(String user_id) throws IllegalArgumentException{
        if(user_id == null || user_id.isEmpty())
            throw new IllegalArgumentException("Illegal user_id");
        List<String> follower_ids = userFollowerRepository.getFollower_IdsByUser_Id(user_id);
        List<User> followers = new ArrayList<>();
        for(String follower_id : follower_ids){
            User user = userService.getUser(follower_id);
            followers.add(user);
        }
        return followers;
    }

    public List<User> getFollowings(String follower_id) throws IllegalArgumentException{
        if(follower_id == null || follower_id.isEmpty())
            throw new IllegalArgumentException("Illegal user_id");
        List<String> user_ids = userFollowerRepository.getUser_IdsByFollower_Id(follower_id);
        List<User> followings = new ArrayList<>();
        for(String user_id : user_ids){
            User user = userService.getUser(user_id);
            followings.add(user);
        }
        return followings;
    }

    public void block(String user_id, String blocked_id) throws IllegalArgumentException{
        if(user_id == null || user_id.isEmpty())
            throw new IllegalArgumentException("Illegal user_id");
        if(blocked_id == null || blocked_id.isEmpty())
            throw new IllegalArgumentException("Illegal blocked_id");
        String id = UUID.randomUUID().toString();
        Timestamp creation_date = new Timestamp(new Date().getTime());
        UserBlock userBlock = new UserBlock(id, user_id, blocked_id, creation_date);
        userBlockRepository.save(userBlock);

        /*

        notify other services

        */
    }

    public void unblock(String id) throws IllegalArgumentException{
        if(id == null || id.isEmpty())
            throw new IllegalArgumentException("Illegal id");
        userBlockRepository.deleteById(id);

        /*

        notify other services

        */
    }

    public List<User> getBlockedUsers(String user_id) throws IllegalArgumentException{
        if(user_id == null || user_id.isEmpty())
            throw new IllegalArgumentException("Illegal user_id");
        List<String> blocked_ids = userBlockRepository.findBlocked_IdsByUser_Id(user_id);
        List<User> blocked_users = new ArrayList<>();
        for(String blocked_id : blocked_ids){
            User user = userService.getUser(blocked_id);
            blocked_users.add(user);
        }
        return blocked_users;
    }

    public void addFav(Map<String, String> map) throws IllegalArgumentException{
        String user_id = map.get("user_id");
        String fav_key = map.get("fav_key");
        String fav_value = map.get("fav_value");
        if(user_id == null || user_id.isEmpty())
            throw new IllegalArgumentException("Illegal user_id");
        if(fav_key == null || fav_key.isEmpty())
            throw new IllegalArgumentException("Illegal fav_key");
        if(fav_value == null || fav_value.isEmpty())
            throw new IllegalArgumentException("Illegal fav_value");
        UserFav userFav = userFavRepository.findUserFavByUser_Id(user_id);
        if(fav_key.equalsIgnoreCase("movies")){
            List<String> list = StringListConvertor.convertStringToList(userFav.getMovies());
            if(!list.contains(fav_value))
                list.add(fav_value);
            userFav.setMovies(StringListConvertor.convertListToString(list));
        }
        if(fav_key.equalsIgnoreCase("actors")){
            List<String> list = StringListConvertor.convertStringToList(userFav.getActors());
            if(!list.contains(fav_value))
                list.add(fav_value);
            userFav.setActors(StringListConvertor.convertListToString(list));
        }
        if(fav_key.equalsIgnoreCase("books")){
            List<String> list = StringListConvertor.convertStringToList(userFav.getBooks());
            if(!list.contains(fav_value))
                list.add(fav_value);
            userFav.setBooks(StringListConvertor.convertListToString(list));
        }
        if(fav_key.equalsIgnoreCase("songs")){
            List<String> list = StringListConvertor.convertStringToList(userFav.getSongs());
            if(!list.contains(fav_value))
                list.add(fav_value);
            userFav.setSongs(StringListConvertor.convertListToString(list));
        }
        if(fav_key.equalsIgnoreCase("sports")){
            List<String> list = StringListConvertor.convertStringToList(userFav.getSports());
            if(!list.contains(fav_value))
                list.add(fav_value);
            userFav.setSports(StringListConvertor.convertListToString(list));
        }
        if(fav_key.equalsIgnoreCase("sportsperson")){
            List<String> list = StringListConvertor.convertStringToList(userFav.getSportspersons());
            if(!list.contains(fav_value))
                list.add(fav_value);
            userFav.setSportspersons(StringListConvertor.convertListToString(list));
        }
        if(fav_key.equalsIgnoreCase("places")){
            List<String> list = StringListConvertor.convertStringToList(userFav.getPlaces());
            if(!list.contains(fav_value))
                list.add(fav_value);
            userFav.setPlaces(StringListConvertor.convertListToString(list));
        }
        Timestamp latest_modified_date = new Timestamp(new Date().getTime());
        userFav.setLatest_modified_date(latest_modified_date);
        userFavRepository.save(userFav);
    }

    public void remFav(Map<String, String> map) throws IllegalArgumentException{
        String user_id = map.get("user_id");
        String fav_key = map.get("fav_key");
        String fav_value = map.get("fav_value");
        if(user_id == null || user_id.isEmpty())
            throw new IllegalArgumentException("Illegal user_id");
        if(fav_key == null || fav_key.isEmpty())
            throw new IllegalArgumentException("Illegal fav_key");
        if(fav_value == null || fav_value.isEmpty())
            throw new IllegalArgumentException("Illegal fav_value");
        UserFav userFav = userFavRepository.findUserFavByUser_Id(user_id);
        if(fav_key.equalsIgnoreCase("movies")){
            List<String> list = StringListConvertor.convertStringToList(userFav.getMovies());
            list.remove(fav_value);
            userFav.setMovies(StringListConvertor.convertListToString(list));
        }
        if(fav_key.equalsIgnoreCase("actors")){
            List<String> list = StringListConvertor.convertStringToList(userFav.getActors());
            list.remove(fav_value);
            userFav.setActors(StringListConvertor.convertListToString(list));
        }
        if(fav_key.equalsIgnoreCase("books")){
            List<String> list = StringListConvertor.convertStringToList(userFav.getBooks());
            list.remove(fav_value);
            userFav.setBooks(StringListConvertor.convertListToString(list));
        }
        if(fav_key.equalsIgnoreCase("songs")){
            List<String> list = StringListConvertor.convertStringToList(userFav.getSongs());
            list.remove(fav_value);
            userFav.setSongs(StringListConvertor.convertListToString(list));
        }
        if(fav_key.equalsIgnoreCase("sports")){
            List<String> list = StringListConvertor.convertStringToList(userFav.getSports());
            list.remove(fav_value);
            userFav.setSports(StringListConvertor.convertListToString(list));
        }
        if(fav_key.equalsIgnoreCase("sportsperson")){
            List<String> list = StringListConvertor.convertStringToList(userFav.getSportspersons());
            list.remove(fav_value);
            userFav.setSportspersons(StringListConvertor.convertListToString(list));
        }
        if(fav_key.equalsIgnoreCase("places")){
            List<String> list = StringListConvertor.convertStringToList(userFav.getPlaces());
            list.remove(fav_value);
            userFav.setPlaces(StringListConvertor.convertListToString(list));
        }
        Timestamp latest_modified_date = new Timestamp(new Date().getTime());
        userFav.setLatest_modified_date(latest_modified_date);
        userFavRepository.save(userFav);
    }

    public UserFav getUserFavs(String user_id) throws IllegalArgumentException{
        if(user_id == null || user_id.isEmpty())
            throw new IllegalArgumentException("Illegal user_id");
        UserFav userFav = userFavRepository.findUserFavByUser_Id(user_id);
        return userFav;
    }

}
