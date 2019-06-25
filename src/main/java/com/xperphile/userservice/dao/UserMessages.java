package com.xperphile.userservice.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "user_messages")
public class UserMessages {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "user_id")
    private String user_id;

    @Column(name = "messager_id")
    private String messager_id;

    @Column(name = "message")
    private String message;

    @Column(name = "creation_date")
    private Timestamp creation_date;

    @Column(name = "deletion_date")
    private Timestamp deletion_date;

    @Column(name = "referred_message")
    private String referred_message;

    @Column(name = "status")
    private String status;

    public UserMessages() {
    }

    public UserMessages(String id, String user_id, String messager_id, String message, Timestamp creation_date, Timestamp deletion_date, String referred_message, String status) {
        this.id = id;
        this.user_id = user_id;
        this.messager_id = messager_id;
        this.message = message;
        this.creation_date = creation_date;
        this.deletion_date = deletion_date;
        this.referred_message = referred_message;
        this.status = status;
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

    public String getMessager_id() {
        return messager_id;
    }

    public void setMessager_id(String messager_id) {
        this.messager_id = messager_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Timestamp creation_date) {
        this.creation_date = creation_date;
    }

    public Timestamp getDeletion_date() {
        return deletion_date;
    }

    public void setDeletion_date(Timestamp deletion_date) {
        this.deletion_date = deletion_date;
    }

    public String getReferred_message() {
        return referred_message;
    }

    public void setReferred_message(String referred_message) {
        this.referred_message = referred_message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
