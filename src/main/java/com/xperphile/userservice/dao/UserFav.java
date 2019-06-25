package com.xperphile.userservice.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "user_fav")
public class UserFav {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "user_id")
    private String user_id;

    @Column(name = "movies")
    private String movies;

    @Column(name = "books")
    private String books;

    @Column(name = "songs")
    private String songs;

    @Column(name = "actors")
    private String actors;

    @Column(name = "places")
    private String places;

    @Column(name = "sportspersons")
    private String sportspersons;

    @Column(name = "sports")
    private String sports;

    @Column(name = "latest_modified_date")
    private Timestamp latest_modified_date;

    public UserFav() {
    }

    public UserFav(String id, String user_id, String movies, String books, String songs, String actors, String places, String sportspersons, String sports, Timestamp latest_modified_date) {
        this.id = id;
        this.user_id = user_id;
        this.movies = movies;
        this.books = books;
        this.songs = songs;
        this.actors = actors;
        this.places = places;
        this.sportspersons = sportspersons;
        this.sports = sports;
        this.latest_modified_date = latest_modified_date;
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

    public String getMovies() {
        return movies;
    }

    public void setMovies(String movies) {
        this.movies = movies;
    }

    public String getBooks() {
        return books;
    }

    public void setBooks(String books) {
        this.books = books;
    }

    public String getSongs() {
        return songs;
    }

    public void setSongs(String songs) {
        this.songs = songs;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }

    public String getSportspersons() {
        return sportspersons;
    }

    public void setSportspersons(String sportspersons) {
        this.sportspersons = sportspersons;
    }

    public String getSports() {
        return sports;
    }

    public void setSports(String sports) {
        this.sports = sports;
    }

    public Timestamp getLatest_modified_date() {
        return latest_modified_date;
    }

    public void setLatest_modified_date(Timestamp latest_modified_date) {
        this.latest_modified_date = latest_modified_date;
    }
}
