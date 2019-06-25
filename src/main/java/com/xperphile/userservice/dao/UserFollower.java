package com.xperphile.userservice.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "user_follower")
public class UserFollower {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "user_id")
    private String user_id;

    @Column(name = "follower_id")
    private String follower_id;

    @Column(name = "creation_date")
    private Timestamp creation_date;

    public UserFollower() {
    }

    public UserFollower(String id, String user_id, String follower_id, Timestamp creation_date) {
        this.id = id;
        this.user_id = user_id;
        this.follower_id = follower_id;
        this.creation_date = creation_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFollower_id() {
        return follower_id;
    }

    public void setFollower_id(String follower_id) {
        this.follower_id = follower_id;
    }

    public Timestamp getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Timestamp creation_date) {
        this.creation_date = creation_date;
    }
}
