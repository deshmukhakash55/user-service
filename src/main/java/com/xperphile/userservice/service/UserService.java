package com.xperphile.userservice.service;

import com.xperphile.userservice.dao.User;
import com.xperphile.userservice.dao.UserFav;
import com.xperphile.userservice.dao.UserFollower;
import com.xperphile.userservice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserFavRepository userFavRepository;

    @Autowired
    private UserFollowerRepository userFollowerRepository;

    @Autowired
    private UserMessagesRepository userMessagesRepository;

    @Autowired
    private UserBlockRepository userBlockRepository;

    public void addUser (Map<String, String> map) throws IllegalArgumentException{
        String username = map.get("username");
        String email = map.get("email");
        String profile_pic = map.get("profile_pic");
        String base_pic = map.get("base_pic");
        String country = map.get("country");
        String state = map.get("state");
        String pin_code = map.get("pin_code");
        String address = map.get("address");
        String mobile = map.get("mobile");
        String first_name = map.get("first_name");
        String middle_name = map.get("middle_name");
        String last_name = map.get("last_name");
        String gender = map.get("gender");
        if(username == null || username.isEmpty())
            throw new IllegalArgumentException("Illegal Username");
        if(email == null || email.isEmpty())
            throw new IllegalArgumentException("Illegal Email");
        if(country == null || country.isEmpty())
            throw new IllegalArgumentException("Illegal Country");
        if(pin_code == null || pin_code.isEmpty())
            throw new IllegalArgumentException("Illegal Pin Code");
        if(first_name == null || first_name.isEmpty())
            throw new IllegalArgumentException("Illegal First Name");
        if(last_name == null || last_name.isEmpty())
            throw new IllegalArgumentException("Illegal Last Name");
        if(gender == null || gender.isEmpty())
            throw new IllegalArgumentException("Illegal Gender");
        User tmpUser = userRepository.findByEmail(email);
        if(null != tmpUser)
            throw new IllegalArgumentException("User with same email already exists");
        String id = UUID.randomUUID().toString();
        String fav_id = UUID.randomUUID().toString();
        Timestamp creation_date =  new Timestamp(new Date().getTime());
        Timestamp last_modified_date =  new Timestamp(new Date().getTime());
        User user = new User(id, username, email, profile_pic, base_pic, country, state, pin_code, address, mobile, first_name, middle_name, last_name, gender, new BigInteger("0"),creation_date, last_modified_date);
        UserFav userFav = new UserFav(fav_id, id, "", "", "", "", "", "", "", creation_date);
        userRepository.save(user);
        userFavRepository.save(userFav);
    }

    public void updateUser (Map<String, String> map) throws IllegalArgumentException{
        String username = map.get("username");
        String email = map.get("email");
        String profile_pic = map.get("profile_pic");
        String base_pic = map.get("base_pic");
        String country = map.get("country");
        String state = map.get("state");
        String pin_code = map.get("pin_code");
        String address = map.get("address");
        String mobile = map.get("mobile");
        String first_name = map.get("first_name");
        String middle_name = map.get("middle_name");
        String last_name = map.get("last_name");
        String gender = map.get("gender");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date creation_date_object = null;
        try{
            creation_date_object = simpleDateFormat.parse(map.get("creation_time"));
        }
        catch (ParseException exception){
            throw new IllegalArgumentException("Illegal creation_date");
        }
        Timestamp creation_date = new Timestamp(creation_date_object.getTime());
        String id = map.get("id");
        if(id == null || id.isEmpty())
            throw new IllegalArgumentException("Illegal Id");
        if(username == null || username.isEmpty())
            throw new IllegalArgumentException("Illegal Username");
        if(email == null || email.isEmpty())
            throw new IllegalArgumentException("Illegal Email");
        if(country == null || country.isEmpty())
            throw new IllegalArgumentException("Illegal Country");
        if(pin_code == null || pin_code.isEmpty())
            throw new IllegalArgumentException("Illegal Pin Code");
        if(first_name == null || first_name.isEmpty())
            throw new IllegalArgumentException("Illegal First Name");
        if(last_name == null || last_name.isEmpty())
            throw new IllegalArgumentException("Illegal Last Name");
        if(gender == null || gender.isEmpty())
            throw new IllegalArgumentException("Illegal Gender");
        Timestamp last_modified_date =  new Timestamp(new Date().getTime());
        User user = new User(id, username, email, profile_pic, base_pic, country, state, pin_code, address, mobile, first_name, middle_name, last_name, gender, new BigInteger("0"),creation_date, last_modified_date);
        userRepository.save(user);
    }

    public User getUser(String id) throws IllegalArgumentException{
        if(id == null || id.isEmpty())
            throw new IllegalArgumentException("Illegal id");
        User user = userRepository.findById(id).get();
        return user;
    }

    public List<User> searchUsersByUsername(String search_name) throws IllegalArgumentException{
        if(search_name == null || search_name.isEmpty())
            throw new IllegalArgumentException("Illegal search_name");
        List<User> users = userRepository.findByUsername(search_name);
        return users;
    }

    public void removeUser(String id) throws IllegalArgumentException{
        if(id == null || id.isEmpty())
            throw new IllegalArgumentException("Illegal id");
        userRepository.deleteById(id);
        userFavRepository.deleteByUser_Id(id);
        userBlockRepository.deleteByUser_Id(id);
        userBlockRepository.deleteByBlocked_Id(id);
        userFollowerRepository.deleteByUser_Id(id);
        userFollowerRepository.deleteByFollower_Id(id);
        userMessagesRepository.deleteByMessager_Id(id);
        userMessagesRepository.deleteByUser_Id(id);
    }

}
