package com.xperphile.userservice.dao;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @JsonProperty("id")
    private String id;

    @Column(name = "username")
    @JsonProperty("username")
    private String username;

    @Column(name = "email")
    @JsonProperty("email")
    private String email;

    @Column(name = "profile_pic")
    @JsonProperty("profile_pic")
    private String profile_pic;

    @Column(name = "base_pic")
    @JsonProperty("base_pic")
    private String base_pic;

    @Column(name = "country")
    @JsonProperty("country")
    private String country;

    @Column(name = "state")
    @JsonProperty("state")
    private String state;

    @Column(name = "pin_code")
    @JsonProperty("pin_code")
    private String pin_code;

    @Column(name = "address")
    @JsonProperty("address")
    private String address;

    @Column(name = "mobile")
    @JsonProperty("mobile")
    private String mobile;

    @Column(name = "first_name")
    @JsonProperty("first_name")
    private String first_name;

    @Column(name = "middle_name")
    @JsonProperty("middle_name")
    private String middle_name;

    @Column(name = "last_name")
    @JsonProperty("last_name")
    private String last_name;

    @Column(name = "gender")
    @JsonProperty("gender")
    private String gender;

    @Column(name = "followers")
    @JsonProperty("followers")
    private BigInteger followers;

    @Column(name = "creation_time")
    @JsonProperty("creation_time")
    private Timestamp creation_time;

    @Column(name = "latest_modified_time")
    @JsonProperty("latest_modified_time")
    private Timestamp latest_modified_time;

    public User(String id, String username, String email, String profile_pic, String base_pic, String country, String state, String pin_code, String address, String mobile, String first_name, String middle_name, String last_name, String gender, BigInteger followers, Timestamp creation_time, Timestamp latest_modified_time) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.profile_pic = profile_pic;
        this.base_pic = base_pic;
        this.country = country;
        this.state = state;
        this.pin_code = pin_code;
        this.address = address;
        this.mobile = mobile;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.gender = gender;
        this.followers = followers;
        this.creation_time = creation_time;
        this.latest_modified_time = latest_modified_time;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public String getBase_pic() {
        return base_pic;
    }

    public void setBase_pic(String base_pic) {
        this.base_pic = base_pic;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPin_code() {
        return pin_code;
    }

    public void setPin_code(String pin_code) {
        this.pin_code = pin_code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BigInteger getFollowers() {
        return followers;
    }

    public void setFollowers(BigInteger followers) {
        this.followers = followers;
    }

    public Timestamp getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(Timestamp creation_time) {
        this.creation_time = creation_time;
    }

    public Timestamp getLatest_modified_time() {
        return latest_modified_time;
    }

    public void setLatest_modified_time(Timestamp latest_modified_time) {
        this.latest_modified_time = latest_modified_time;
    }
}
