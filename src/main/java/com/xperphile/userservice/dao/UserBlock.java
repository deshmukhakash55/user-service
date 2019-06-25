package com.xperphile.userservice.dao;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "user_block")
public class UserBlock {

    @Id
    @Column(name = "id")
    @JsonProperty("id")
    private String id;

    @Column(name = "user_id")
    @JsonProperty("user_id")
    private String user_id;

    @Column(name = "blocked_id")
    @JsonProperty("blocked_id")
    private String blocked_id;

    @Column(name = "creation_time")
    private Timestamp creation_time;

    public UserBlock() {
    }

    public UserBlock(String id, String user_id, String blocked_id, Timestamp creation_time) {
        this.id = id;
        this.user_id = user_id;
        this.blocked_id = blocked_id;
        this.creation_time = creation_time;
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

    public String getBlocked_id() {
        return blocked_id;
    }

    public void setBlocked_id(String blocked_id) {
        this.blocked_id = blocked_id;
    }

    public Timestamp getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(Timestamp creation_time) {
        this.creation_time = creation_time;
    }
}
