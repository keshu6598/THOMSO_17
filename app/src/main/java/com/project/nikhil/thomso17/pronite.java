package com.project.nikhil.thomso17;

import java.io.Serializable;

/**
 * Created by nikhil on 13/10/17.
 */

public class pronite implements Serializable {

    String day;
    String date;
    String name;
    String artist;
    String descrioption;
    String venue;
    String image;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrioption() {
        return descrioption;
    }

    public void setDescrioption(String descrioption) {
        this.descrioption = descrioption;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public pronite(String day, String date, String name, String artist, String descrioption, String venue, String image, String time) {

        this.day = day;
        this.date = date;
        this.artist=artist;

        this.name = name;
        this.descrioption = descrioption;
        this.venue = venue;
        this.image = image;
        this.time = time;
    }

    String time;

}
